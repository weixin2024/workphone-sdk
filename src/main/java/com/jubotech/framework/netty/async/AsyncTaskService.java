package com.jubotech.framework.netty.async;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.Message;
import com.jubotech.business.web.dao.FriendAddTaskDao;
import com.jubotech.business.web.dao.FriendAddTaskDetailsDao;
import com.jubotech.business.web.dao.PhoneNumberDao;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.CircleInfo;
import com.jubotech.business.web.domain.FriendAddTask;
import com.jubotech.business.web.domain.FriendAddTaskDetails;
import com.jubotech.business.web.domain.PhoneNumberInfo;
import com.jubotech.business.web.domain.SysAutoSetting;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.domain.WxContactInfo;
import com.jubotech.business.web.domain.WxMessageInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.CircleService;
import com.jubotech.business.web.service.SysAutoSettingService;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.business.web.service.WxContactService;
import com.jubotech.business.web.service.WxMessageService;
import com.jubotech.framework.common.AutoType;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.ByteStringToString;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.MsgIdBuilder;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;
import com.jubotech.framework.util.EmojiFilter;
import com.jubotech.framework.util.JsonUtils;

import Jubo.JuLiao.IM.Wx.Proto.AcceptFriendAddRequestTask.AcceptFriendAddRequestTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.AgreeJoinChatRoomTask.AgreeJoinChatRoomTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.ChatRoomPushNotice.ChatRoomMessage;
import Jubo.JuLiao.IM.Wx.Proto.ChatRoomPushNotice.ChatRoomPushNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.CircleDetailNotice.CircleDetailNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.CircleNewPublishNotice.CircleInformationMessage;
import Jubo.JuLiao.IM.Wx.Proto.CircleNewPublishNotice.CircleInformationMessage.CircleContentMessage;
import Jubo.JuLiao.IM.Wx.Proto.CircleNewPublishNotice.CircleInformationMessage.CircleContentMessage.CircleNewsContentMessage;
import Jubo.JuLiao.IM.Wx.Proto.CirclePushNotice.CirclePushNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.FriendAddNotice.FriendAddNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.FriendAddNotice.FriendMessage;
import Jubo.JuLiao.IM.Wx.Proto.FriendAddReqeustNotice.FriendAddReqeustNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.FriendPushNotice.FriendPushNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.FriendTalkNotice.FriendTalkNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.SendLuckyMoneyTask.SendLuckyMoneyTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TakeLuckyMoneyTask.TakeLuckyMoneyTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TalkToFriendTask.TalkToFriendTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TaskResultNotice.TaskResultNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumContentType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatOfflineNotice.WeChatOfflineNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatTalkToFriendNotice.WeChatTalkToFriendNoticeMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
@EnableAsync
public class AsyncTaskService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;

	@Autowired
	private WxMessageService weChatMessageService;

	@Autowired
	private WxContactService weChatContactService;

	@Autowired
	private WxAccountService weChatAccountService;

	@Autowired
	private SysAutoSettingService sysAutoSettingService;

	@Autowired
	private  FriendAddTaskDetailsDao friendAddTaskDetailsDao;
	
	@Autowired
	private  PhoneNumberDao phoneNumberDao;
	
	@Autowired
	private  FriendAddTaskDao  friendAddTaskDao;
	
	/**
	 * 自动抢红包、自动收账
	 * @param ctx
	 * @param type
	 * @param req
	 * @param accessToken
	 * @param msgId
	 */
	private static void takeLuckyMoney(ChannelHandlerContext ctx,Integer type,FriendTalkNoticeMessage req,String accessToken,long msgId){
		String content = ByteStringToString.bytesToString(req.getContent(), "utf-8");
		if(type == AutoType.AUTOTYPE_LUCKMONEY){//红包有个人红包和群红包
			if(!JsonUtils.isJson(content)){//群红包处理
				int index =  content.indexOf("{");
				if(index>0){
					content= content.substring(index,content.length());
				}
			}
		}
		JSONObject json = JSON.parseObject(content);
		String key = null;
		if (null != json) {
			key = json.get("Key").toString();
		}
		if (!StringUtils.isBlank(key)) {
			TakeLuckyMoneyTaskMessage.Builder bd = TakeLuckyMoneyTaskMessage.newBuilder();
			bd.setWeChatId(req.getWeChatId());
			bd.setFriendId(req.getFriendId());
			bd.setMsgSvrId(req.getMsgSvrId());
			bd.setMsgKey(key);
			bd.setTaskId(MsgIdBuilder.getId());
			TakeLuckyMoneyTaskMessage resp = bd.build();
			MessageUtil.sendMsg(ctx, EnumMsgType.TakeLuckyMoneyTask,accessToken,msgId,resp);
		}
		
	}
	
	/**
	 * 拦截手机端消息做一下自动功能
	 * 
	 * @param wechatId
	 * @param type
	 * @param req
	 */
	@Async
	public void msgAopTask(ChannelHandlerContext ctx, FriendTalkNoticeMessage req,String accessToken,long msgId) {

		try {
			log.info(LocalDateTime.now() + " msgAopTask 对应的线程名: " + Thread.currentThread().getName());
			if (req.getContentType().equals(EnumContentType.LuckyMoney)) {// 红包消息
				SysAutoSetting sys = sysAutoSettingService.findSettingByWcIdAutoType(req.getWeChatId(),AutoType.AUTOTYPE_LUCKMONEY);
				if (null != sys) {
					if (null != req.getContent()) {
						takeLuckyMoney(ctx, AutoType.AUTOTYPE_LUCKMONEY, req, accessToken, msgId);
					}
				}
			}
			
			if (req.getContentType().equals(EnumContentType.MoneyTrans)) {// 转账消息
				SysAutoSetting sys = sysAutoSettingService.findSettingByWcIdAutoType(req.getWeChatId(),AutoType.AUTOTYPE_MONEYTRANS);
				if (null != sys) {
					if (null != req.getContent()) {
						takeLuckyMoney(ctx, AutoType.AUTOTYPE_MONEYTRANS, req, accessToken, msgId);
					}
				}
			}
			 
			if (req.getContentType().equals(EnumContentType.Link)) {// 链接消息，判断是否是群邀请链接
				String content = ByteStringToString.bytesToString(req.getContent(), "utf-8");
				if(!JsonUtils.isJson(content)){
					int index =  content.indexOf("{");
					if(index>0){
						content= content.substring(index,content.length());
					}
				}
				JSONObject json = JSON.parseObject(content);
				Object obj = json.get("Title");
				if (null != obj) {
					String title = obj.toString();
					if (title.contains("邀请你加入群聊")) {
						Object url = json.get("Url");
						if (null != url) {
							if (url.toString().contains("https://support.weixin.qq.com/cgi-bin")) {
								SysAutoSetting sys = sysAutoSettingService.findSettingByWcIdAutoType(req.getWeChatId(),AutoType.AUTOTYPE_GROUPINVITATION);
								if (null != sys) {
									String talker = req.getFriendId();
									AgreeJoinChatRoomTaskMessage.Builder bd = AgreeJoinChatRoomTaskMessage.newBuilder();
									bd.setWeChatId(req.getWeChatId());
									bd.setMsgSvrId(req.getMsgSvrId());
									bd.setTalker(talker);
									bd.setTaskId(MsgIdBuilder.getId());
									bd.setMsgContent(content);
									AgreeJoinChatRoomTaskMessage resp = bd.build();
									MessageUtil.sendMsg(ctx, EnumMsgType.AgreeJoinChatRoomTask,accessToken,msgId, resp);
								}
							}
						}
						
						
					}
				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 拦截手机端好友请求消息
	 * 
	 * @param wechatId
	 * @param type
	 * @param req
	 */
	@Async
	public void msgAopTaskFriendAdd(ChannelHandlerContext ctx, FriendAddReqeustNoticeMessage req,String accessToken,long msgId) {
		try {
			log.info(LocalDateTime.now() + " msgAopTask 对应的线程名: " + Thread.currentThread().getName());
			SysAutoSetting sys = sysAutoSettingService.findSettingByWcIdAutoType(req.getWeChatId(),AutoType.AUTOTYPE_FRIENDREQEST);
			if (null != sys) {
				AcceptFriendAddRequestTaskMessage.Builder  bd = AcceptFriendAddRequestTaskMessage.newBuilder();
				bd.setWeChatId(req.getWeChatId());
				bd.setFriendId(req.getFriendId());
				bd.setFriendNick(req.getFriendNick());
				bd.setOperationValue(1);//默认接受请求
				AcceptFriendAddRequestTaskMessage resp = bd.build();
				MessageUtil.sendMsg(ctx, EnumMsgType.AcceptFriendAddRequestTask, accessToken, msgId, resp);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	
	

	/**
	 * 转发消息给pc客户端
	 * 
	 * @param wechatId
	 * @param type
	 * @param req
	 */
	@Async
	public void msgSend2pc(String wechatId, EnumMsgType type, Message req) {

		try {
			log.info(LocalDateTime.now() + " msgSend2pc 对应的线程名: " + Thread.currentThread().getName());
			// 先从缓存取，如果取不到再用sql取
			List<WxAccountInfo> accountInfoList = Constant.accountInfoList;
			if (null == accountInfoList || accountInfoList.size() == 0) {
				// 刷新缓存
				accountInfoList = weChatAccountService.refreshCache();
			}

			String account = null;
			if (null != accountInfoList && accountInfoList.size() > 0) {
				for (int i = 0; i < accountInfoList.size(); i++) {
					WxAccountInfo ainfo = accountInfoList.get(i);
					if (null != ainfo && ainfo.getWechatid().equals(wechatId)) {
						account = ainfo.getAccount();
						break;
					}
				}
			} else {
				AccountInfo accInfo = accountService.findAccountInfoByWeChatId(wechatId);
				if (null != accInfo) {
					account = accInfo.getAccount();
					// 刷新缓存
					weChatAccountService.refreshCache();
				}
			}

			if (!StringUtils.isBlank(account)) {
				// 转发给pc端
				ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(account);
				if (null != chx) {
					MessageUtil.sendJsonMsg(chx, type, NettyConnectionUtil.getNettyId(chx), null, req);
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * 转发消息给手机客户端
	 * 
	 * @param ctx
	 * @param wechatId
	 * @param type
	 * @param vo
	 * @param req
	 */
	@Async
	public void msgSend2Phone(ChannelHandlerContext ctx, String wechatId, EnumMsgType type, TransportMessage vo,Message req) {

		try {
			log.info(LocalDateTime.now() + " msgSend2Phone 对应的线程名: " + Thread.currentThread().getName());

			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(wechatId);
			if (null != chx) {
				// 转发给手机端
				MessageUtil.sendMsg(chx, type, vo.getAccessToken(), null, req);
				// 告诉发送方 消息已经收到
				MessageUtil.sendJsonMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
			} else {
				// 对方不在线
				MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.TargetNotOnline,Constant.createErrorMsg(wechatId, Constant.ERROR_MSG_NOTONLINE));
				// 做个保护，如果微信不在线，则通知pc端，下线其微信
				WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(wechatId);
				account.setIsonline(1);// 下线
				weChatAccountService.updateOnline(account);
				// 通知pc端下线其微信
				WeChatOfflineNoticeMessage resp = WeChatOfflineNoticeMessage.newBuilder().setWeChatId(wechatId).build();
				MessageUtil.sendJsonMsg(ctx, EnumMsgType.WeChatOfflineNotice, NettyConnectionUtil.getNettyId(ctx),null, resp);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存通讯录录列表数据
	 * 
	 * @param req
	 * @param account
	 */
	@Async
	public void friendListSave(FriendPushNoticeMessage req) {
		log.info(LocalDateTime.now() + " friendListSave 对应的线程名: " + Thread.currentThread().getName());
		WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
		if(null == account){
			return;
		}
		List<FriendMessage> friendList = req.getFriendsList();
		if (null != friendList && friendList.size() > 0) {
			String wechatId = req.getWeChatId();
			for (int i = 0; i < friendList.size(); i++) {
				FriendMessage friend = friendList.get(i);
				if (null != friend) {
					try {
						WxContactInfo contactinfo = weChatContactService.findContactinfoByfriendid(account.getCid(),
								wechatId, friend.getFriendId());
						if (null != contactinfo) {
							setContActinfo(contactinfo, friend);
							weChatContactService.update(contactinfo);
						} else {
							contactinfo = new WxContactInfo();
							setContActinfo(contactinfo, friend);
							contactinfo.setCid(account.getCid());
							contactinfo.setWechatid(req.getWeChatId());
							contactinfo.setFriendid(friend.getFriendId());
							weChatContactService.insert(contactinfo);
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * 保存新增好友数据
	 * @param req
	 */
	@Async
	public  void saveFriendAddContactinfo(FriendAddNoticeMessage req){
    	try {
    		WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
    		if(null == account){
    			return;
    		}
			//新增好友
			FriendMessage  friend = req.getFriend();
			WxContactInfo   contactinfo = weChatContactService.findContactinfoByfriendid(account.getCid(),req.getWeChatId(),friend.getFriendId());
			if(null != contactinfo){
				setContActinfo(contactinfo, friend);
				weChatContactService.update(contactinfo);
			}else{
				contactinfo = new WxContactInfo();
				setContActinfo(contactinfo, friend);
				contactinfo.setCid(account.getCid());
				contactinfo.setWechatid(req.getWeChatId());
				contactinfo.setFriendid(friend.getFriendId());
				weChatContactService.insert(contactinfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	private static void setContActinfo(WxContactInfo contactinfo, FriendMessage friend) {
		String nickName = EmojiFilter.filterEmoji(friend.getFriendNick());//过滤emoji
		contactinfo.setFriend_wechatno(friend.getFriendNo());
		contactinfo.setNickname(nickName);
		contactinfo.setGender(friend.getGenderValue());
		contactinfo.setAvatar(friend.getAvatar());
		contactinfo.setRemark(friend.getRemark());
		contactinfo.setCountry(friend.getCountry());
		contactinfo.setProvince(friend.getProvince());
		contactinfo.setCity(friend.getCity());
		contactinfo.setType(0);
	}
	
	/**
	 * 保存群列表数据
	 * 
	 * @param req
	 * @param account
	 */
	@Async
	public void qunListSave(ChatRoomPushNoticeMessage req) {
		log.info(LocalDateTime.now() + " qunListSave 对应的线程名: " + Thread.currentThread().getName());
		WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
		if(null == account){
			return;
		}
		List<ChatRoomMessage> chatRoomList = req.getChatRoomsList();
		if (null != chatRoomList && chatRoomList.size() > 0) {
			String wechatId = req.getWeChatId();
			for (int i = 0; i < chatRoomList.size(); i++) {
				ChatRoomMessage friend = chatRoomList.get(i);
				if (null != friend) {
					try {
						WxContactInfo contactinfo = weChatContactService.findContactinfoByfriendid(account.getCid(),wechatId, friend.getUserName());
						String nickName = EmojiFilter.filterEmoji(friend.getNickName());//过滤emoji
						if (null != contactinfo) {
							contactinfo.setNickname(nickName);
							contactinfo.setAvatar(friend.getAvatar());
							contactinfo.setRemark(friend.getRemark());
							
							weChatContactService.update(contactinfo);
						} else {
							contactinfo = new WxContactInfo();
							contactinfo.setNickname(nickName);
							contactinfo.setAvatar(friend.getAvatar());
							contactinfo.setRemark(friend.getRemark());
							contactinfo.setCid(account.getCid());
							contactinfo.setWechatid(req.getWeChatId());
							contactinfo.setFriendid(friend.getUserName());
							contactinfo.setType(1);
							weChatContactService.insert(contactinfo);
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
 

	/**
	 * 修改msgserverid
	 */
	@Async
	public void updateMsgServerId(String weChatId, String friendId, long msgId, long msgServerId) {
		try {
			log.info(LocalDateTime.now() + " updateMsgServerId 对应的线程名: " + Thread.currentThread().getName());
			WxMessageInfo msgInfo = weChatMessageService.queryWeChatMessageInfoByMsgServerId(weChatId, friendId,String.valueOf(msgId));
			if (null != msgInfo) {
				msgInfo.setMsgSvrId(String.valueOf(msgServerId));
				weChatMessageService.update(msgInfo);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改图片，视频，文件地址
	 */
	@Async
	public void updateFileMsgContent(String weChatId,String content, long msgServerId) {
		try {
			log.info(LocalDateTime.now() + " updateFileMsgContent 对应的线程名: " + Thread.currentThread().getName());
			WxMessageInfo msgInfo = weChatMessageService.queryWeChatMessageInfoByMsgServerId(weChatId, null,String.valueOf(msgServerId));
			if (null != msgInfo) {
				msgInfo.setContent(content);
				weChatMessageService.updateContent(msgInfo);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存消息
	 * 
	 * @param weChatMessageService
	 * @param account
	 * @param req
	 */
	@Async
	public void saveMessage(WxAccountInfo account, FriendTalkNoticeMessage req) {
		try {
			log.info(LocalDateTime.now() + " saveMessage 对应的线程名: " + Thread.currentThread().getName());

			WxMessageInfo info = new WxMessageInfo();
			String content = ByteStringToString.bytesToString(req.getContent(), "utf-8");
			info.setCid(account.getCid());
			info.setWechatId(req.getWeChatId());
			info.setFriendId(req.getFriendId());
			info.setMsgSvrId(String.valueOf(req.getMsgSvrId()));
			info.setIsSend("false");// 收到的消息
			info.setContentType(req.getContentTypeValue());
			info.setContent(content);// base64了 需要解码存储
			if(req.getFriendId().contains("chatroom")){
				info.setType(1);
			}else{
				info.setType(0);
			}
			weChatMessageService.insert(info);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存发送消息
	 * 
	 * @param req
	 */
	@Async
	public void savePcMessage(TalkToFriendTaskMessage req) {
		log.info(LocalDateTime.now() + " savePcMessage 对应的线程名: " + Thread.currentThread().getName());
		WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
		if (null != account) {
			try {
				WxMessageInfo info = new WxMessageInfo();
				String content = ByteStringToString.bytesToString(req.getContent(), "utf-8");
				info.setCid(account.getCid());
				info.setWechatId(req.getWeChatId());
				info.setFriendId(req.getFriendId());
				info.setMsgSvrId(String.valueOf(req.getMsgId()));
				info.setIsSend("true");// 发送
				info.setContentType(req.getContentTypeValue());
				info.setContent(content);// base64了 需要解码存储
				if(req.getFriendId().contains("chatroom")){
					info.setType(1);
				}else{
					info.setType(0);
				}
				weChatMessageService.insert(info);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 保存红包消息
	 * 
	 * @param req
	 * @param contentJsonStr
	 */
	@Async
	public void saveLuckyMoneyMessage(SendLuckyMoneyTaskMessage req, String contentJsonStr) {
		log.info(LocalDateTime.now() + " saveLuckyMoneyMessage 对应的线程名: " + Thread.currentThread().getName());
		WxAccountInfo wechat = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
		if (null != wechat) {
			try {
				WxMessageInfo info = new WxMessageInfo();
				String content = contentJsonStr;
				info.setCid(wechat.getCid());
				info.setWechatId(req.getWeChatId());
				info.setFriendId(req.getFriendId());
				info.setMsgSvrId(String.valueOf(req.getTaskId()));
				info.setIsSend("true");// 发送
				info.setContentType(11);
				info.setContent(content);
				if(req.getFriendId().contains("chatroom")){
					info.setType(1);
				}else{
					info.setType(0);
				}
				weChatMessageService.insert(info);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 手机上回复了好友消息，消息记录上传
	 * @param req
	 */
	@Async
	public  void savePhoneSendMessage(WeChatTalkToFriendNoticeMessage req){
	    	WxAccountInfo  account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
	    	if(null != account){
	    		try {
					WxMessageInfo info = new WxMessageInfo();
					String content = ByteStringToString.bytesToString(req.getContent(), "utf-8");
					info.setCid(account.getCid());
					info.setWechatId(req.getWeChatId());
					info.setFriendId(req.getFriendId());
					info.setMsgSvrId(String.valueOf(req.getMsgSvrId()));
					info.setIsSend("true");//发送
					info.setContentType(req.getContentTypeValue());
					info.setContent(content);//base64了 需要解码存储
					if(req.getFriendId().contains("chatroom")){
						info.setType(1);
					}else{
						info.setType(0);
					}
					weChatMessageService.insert(info);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	}
	
	
	/**
	 * 修改加好友任务结果
	 * @param req
	 */
	@Async
	public  void updateFriendAddMessage(TaskResultNoticeMessage req){
	    try {
			if(null != req && req.getTaskType()==EnumMsgType.AddFriendsTask){
				Long  taskid = req.getTaskId();
				if(null != taskid){
					FriendAddTaskDetails taskDetails = friendAddTaskDetailsDao.findFriendAddTaskDetailsByid(taskid.intValue());
					if(null != taskDetails){
						if(taskDetails.getWechatid().equals(req.getWeChatId())){
							PhoneNumberInfo phoneNumberInfo = phoneNumberDao.queryPhoneNumberInfoByWechatidPhoneNumber(taskDetails.getWechatid(), taskDetails.getPhonenumber());
							if(null != phoneNumberInfo){
								if(req.getSuccess()){
									phoneNumberInfo.setTask_result(0);
									
									FriendAddTask friendAddTask = friendAddTaskDao.findFriendAddTaskByid(taskDetails.getTid());
									if(null != friendAddTask){
										Integer newsussesize = friendAddTask.getSuccesssize()+1;
										friendAddTask.setSuccesssize(newsussesize);
										friendAddTaskDao.update(friendAddTask);
									}
									
								}else{
									phoneNumberInfo.setTask_result(1);
								}
								phoneNumberDao.update(phoneNumberInfo);
								 
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
     * 倔牛 独有的业务
     * @param req
     */
    @Async
    public void asyncSaveCircleMsg(CirclePushNoticeMessage req,CircleService circleService,WxContactService weChatContactService){
    	try {
			String  wechatid = req.getWeChatId();
			//爱咋咋地
			List<CircleInformationMessage> list = req.getCirclesList();
			if(null != list && list.size()>0){
				for(int i=0;i<list.size();i++){
					CircleInformationMessage circle =  list.get(i);
					CircleContentMessage content = circle.getContent();
					String text = content.getText();
					List<CircleNewsContentMessage> images =  content.getImagesList();//获取缩略图列表
					CircleNewsContentMessage  link = content.getLink();//获取链接
					CircleNewsContentMessage video = content.getVideo();//获取视频缩略图
					String thumbimages = "";
					if(null != images && images.size()>0){
						for(int j=0;j<images.size();j++){
							CircleNewsContentMessage imgs= 	images.get(j);
							if(null != imgs && StringUtils.isNoneEmpty(imgs.getThumbImg())){
								thumbimages = thumbimages + imgs.getThumbImg() + ",";
							}
						}
					}
					
					if(!StringUtils.isBlank(thumbimages) && thumbimages.endsWith(",")){
						thumbimages = thumbimages.substring(0, thumbimages.length()-1);
					}
					
					WxContactInfo  contcact =weChatContactService.findContactinfoByWechatidFriendid(wechatid, circle.getWeChatId());
					CircleInfo ccl = new CircleInfo();
					ccl.setSourcewechatid(wechatid);//抓取者
					ccl.setWechatid(circle.getWeChatId());//发布朋友圈的人
                    if(null != contcact){
                    	ccl.setWechatnickname(contcact.getNickname());
					}
					ccl.setCircleid(String.valueOf(circle.getCircleId()));
					ccl.setContent(text);
					ccl.setPublishtime(String.valueOf(circle.getPublishTime()));
					ccl.setThumbimages(thumbimages);
					if(null != link){
						ccl.setLink(link.getUrl());
					}
					if(null != video ){
						ccl.setVideothumbimg(video.getThumbImg());
						ccl.setVideodescription(video.getDescription());
						ccl.setVideomediaid(video.getMediaId());
					}
					
					circleService.insert(ccl);
					
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }
	
    
    /**
     * 倔牛 独有的业务
     * @param req
     */
    @Async
    public  void asyncUpdateCircleMsg(CircleDetailNoticeMessage req,CircleService circleService){
    	try {
		 
			CircleInformationMessage  circle = req.getCircle();
			if(null != circle){
				CircleContentMessage  content = circle.getContent();
				List<CircleNewsContentMessage> newContent = content.getImagesList();
				String imgUrls = "";
				if(null != newContent && newContent.size()>0){
					for(int i=0;i<newContent.size();i++){
						CircleNewsContentMessage news  = newContent.get(i);
						if(null != news && !StringUtils.isBlank(news.getUrl())){
							imgUrls =  imgUrls + news.getUrl()+ ",";
						}
					}
				
					if(!StringUtils.isBlank(imgUrls) && imgUrls.endsWith(",")){
						imgUrls = imgUrls.substring(0, imgUrls.length()-1);
					}
					
				}
				 
				CircleNewsContentMessage video = content.getVideo();
				
				CircleInfo info =	circleService.findCircleInfoByWeChatIdCircleId(circle.getWeChatId(), String.valueOf(circle.getCircleId()));
				if(null != info){
					if(null != video && !StringUtils.isBlank(video.getUrl())){
						info.setVideourl(video.getUrl());
					}
					if(!StringUtils.isBlank(imgUrls)){
						info.setImages(imgUrls);
					}
					if(!StringUtils.isBlank(info.getImages()) || !StringUtils.isBlank(info.getVideourl())){
						circleService.update(info);
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
    }

}
