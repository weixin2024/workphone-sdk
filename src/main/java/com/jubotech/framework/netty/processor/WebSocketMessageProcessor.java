package com.jubotech.framework.netty.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.protobuf.format.JsonFormat;
import com.jubotech.framework.netty.handler.websocket.AcceptFriendAddRequestTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AccountLogoutNoticeWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AddFriendFromPhonebookTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AddFriendInChatRoomTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AddFriendWithSceneTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AddFriendsTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AddTaskTimeInfoWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AgreeJoinChatRoomTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AutoFriendAddTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AutoTaskDetailListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.AutoTaskUpdateWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ChatRoomActionTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ChatRoomInviteApproveTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.CircleCommentDeleteTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.CircleCommentReplyTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.CircleLikeTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ClearAllChatMsgTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ContactLabelDeleteTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ContactLabelTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.DeleteFriendTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.DeleteSNSNewsTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.DeviceAuthReqWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.FindContactTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ForwardMessageByContentTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ForwardMessageTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ForwardMultiMessageTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetAutoFriendAddTaskListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetCommonTagsWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetCommonTermsWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetPhoneNumberListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetTaskInfoListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetWeChatsReqWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetWechatFriendDetailWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.GetWechatFriendListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.HeartBeatReqWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.HistoryMessageListWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.JoinGroupByQrTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.ModifyFriendMemoTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.MsgReceivedAckWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PhoneActionTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostFriendDetectTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostMomentsPraiseTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostSNSNewsTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostStopFriendDetectTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostStopMomentsPraiseTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PostStopWeChatMaintenanceTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PullChatRoomQrCodeTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PullCircleDetailTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PullFriendAddReqListTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PullFriendCircleTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.PullWeChatQrCodeTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.QueryHbDetailTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.QueryHistoryMessageWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RemittanceTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RequestChatRoomInfoTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RequestContactsInfoTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RequestTalkContentTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RequestTalkDetailTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.RevokeMessageTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.SendFriendVerifyTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.SendLuckyMoneyTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.SendMultiPictureTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TakeLuckyMoneyTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TalkToFriendTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerBizContactPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerChatroomPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerCirclePushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerConversationPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerFriendPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerHistoryMsgPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerMessageReadTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.TriggerWechatPushTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.VoiceTransTextTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.WeChatGroupSendTaskWesocketHandler;
import com.jubotech.framework.netty.handler.websocket.WeChatLoginNoticeWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.WeChatMaintenanceTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.WechatLogoutTaskWebsocketHandler;
import com.jubotech.framework.netty.handler.websocket.WechatSettingTaskWebsocketHandler;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 消息处理分发器
 */
@Service
public class WebSocketMessageProcessor {
	private static final Logger log = LoggerFactory.getLogger(WebSocketMessageProcessor.class);
	
	@Autowired
	private HeartBeatReqWebsocketHandler heartBeatReqWebsocketHandler;
	@Autowired
	private GetWeChatsReqWebsocketHandler getWeChatsReqWebsocketHandler;
	@Autowired
	private DeviceAuthReqWebsocketHandler deviceAuthReqWebsocketHandler;
	@Autowired
	private AccountLogoutNoticeWebsocketHandler accountLogoutNoticeWebsocketHandler;
	@Autowired
	private WeChatLoginNoticeWebsocketHandler weChatLoginNoticeWebsocketHandler;
	@Autowired
	private MsgReceivedAckWebsocketHandler msgReceivedAckWebsocketHandler;
	@Autowired
	private TalkToFriendTaskWebsocketHandler talkToFriendTaskWebsocketHandler;
	@Autowired
	private RequestTalkDetailTaskWebsocketHandler requestTalkDetailTaskWebsocketHandler;
	@Autowired
	private AddFriendsTaskWebsocketHandler addFriendsTaskWebsocketHandler;
	@Autowired
	private PostSNSNewsTaskWebsocketHandler postSNSNewsTaskWebsocketHandler;
	@Autowired
	private DeleteSNSNewsTaskWebsocketHandler deleteSNSNewsTaskWebsocketHandler;
	@Autowired
	private AcceptFriendAddRequestTaskWebsocketHandler acceptFriendAddRequestTaskWebsocketHandler;
	@Autowired
	private WeChatGroupSendTaskWesocketHandler weChatGroupSendTaskWesocketHandler;
	@Autowired
	private TriggerFriendPushTaskWebsocketHandler triggerFriendPushTaskWebsocketHandler;
	@Autowired
	private PostFriendDetectTaskWebsocketHandler postFriendDetectTaskWebsocketHandler;
	@Autowired
	private TriggerCirclePushTaskWebsocketHandler triggerCirclePushTaskWebsocketHandler;
	@Autowired
	private CircleCommentDeleteTaskWebsocketHandler  circleCommentDeleteTaskWebsocketHandler;
	@Autowired
	private CircleCommentReplyTaskWebsocketHandler circleCommentReplyTaskWebsocketHandler;
	@Autowired
	private WeChatMaintenanceTaskWebsocketHandler weChatMaintenanceTaskWebsocketHandler;
	@Autowired
	private PostMomentsPraiseTaskWebsocketHandler postMomentsPraiseTaskWebsocketHandler;
	@Autowired
	private PostStopFriendDetectTaskWebsocketHandler postStopFriendDetectTaskWebsocketHandler;
	@Autowired
	private PostStopMomentsPraiseTaskWebsocketHandler  postStopMomentsPraiseTaskWebsocketHandler;
	@Autowired
	private PostStopWeChatMaintenanceTaskWebsocketHandler postStopWeChatMaintenanceTaskWebsocketHandler;
	@Autowired
	private TriggerMessageReadTaskWebsocketHandler triggerMessageReadTaskWebsocketHandler;
	@Autowired
	private RevokeMessageTaskWebsocketHandler  revokeMessageTaskWebsocketHandler;
	@Autowired
	private ForwardMessageTaskWebsocketHandler forwardMessageTaskWebsocketHandler;
	@Autowired
	private TriggerHistoryMsgPushTaskWebsocketHandler triggerHistoryMsgPushTaskWebsocketHandler;
	@Autowired
	private PullFriendCircleTaskWebsocketHandler  pullFriendCircleTaskWebsocketHandler;
	@Autowired
	private PullCircleDetailTaskWebsocketHandler  pullCircleDetailTaskWebsocketHandler;
	@Autowired
	private CircleLikeTaskWebsocketHandler circleLikeTaskWebsocketHandler;
	@Autowired
	private TriggerChatroomPushTaskWebsocketHandler triggerChatroomPushTaskWebsocketHandler;
	@Autowired
	private RequestChatRoomInfoTaskWebsocketHandler requestChatRoomInfoTaskWebsocketHandler;
	@Autowired
	private RequestContactsInfoTaskWebsocketHandler requestContactsInfoTaskWebsocketHandler;
	@Autowired
	private ChatRoomActionTaskWebsocketHandler chatRoomActionTaskWebsocketHandler;
	@Autowired
	private AddFriendInChatRoomTaskWebsocketHandler addFriendInChatRoomTaskWebsocketHandler;
	@Autowired
	private AddFriendFromPhonebookTaskWebsocketHandler addFriendFromPhonebookTaskWebsocketHandler;
	@Autowired
	private DeleteFriendTaskWebsocketHandler deleteFriendTaskWebsocketHandler;
	@Autowired
	private SendLuckyMoneyTaskWebsocketHandler sendLuckyMoneyTaskWebsocketHandler;
	@Autowired
	private RequestTalkContentTaskWebsocketHandler requestTalkContentTaskWebsocketHandler;
	@Autowired
	private ForwardMessageByContentTaskWebsocketHandler forwardMessageByContentTaskWebsocketHandler;
	@Autowired
	private PullWeChatQrCodeTaskWebsocketHandler  pullWeChatQrCodeTaskWebsocketHandler;
	@Autowired
	private PullChatRoomQrCodeTaskWebsocketHandler pullChatRoomQrCodeTaskWebsocketHandler;
	@Autowired
	private ModifyFriendMemoTaskWebsocketHandler modifyFriendMemoTaskWebsocketHandler;
	@Autowired
	private TakeLuckyMoneyTaskWebsocketHandler  takeLuckyMoneyTaskWebsocketHandler;
	
	@Autowired
	private GetTaskInfoListWebsocketHandler getTaskInfoListWebsocketHandler;
	@Autowired
	private ChatRoomInviteApproveTaskWebsocketHandler  chatRoomInviteApproveTaskWebsocketHandler;
	@Autowired
	private WechatLogoutTaskWebsocketHandler wechatLogoutTaskWebsocketHandler;
	@Autowired
	private PhoneActionTaskWebsocketHandler  phoneActionTaskWebsocketHandler;
	@Autowired
	private ContactLabelTaskWebsocketHandler  contactLabelTaskWebsocketHandler;
	@Autowired
	private ContactLabelDeleteTaskWebsocketHandler  contactLabelDeleteTaskWebsocketHandler;
	@Autowired
	private VoiceTransTextTaskWebsocketHandler voiceTransTextTaskWebsocketHandler;
	@Autowired
	private FindContactTaskWebsocketHandler  findContactTaskWebsocketHandler;	
	@Autowired
	private AgreeJoinChatRoomTaskWebsocketHandler  agreeJoinChatRoomTaskWebsocketHandler;
	@Autowired
	private ClearAllChatMsgTaskWebsocketHandler  clearAllChatMsgTaskWebsocketHandler;
	@Autowired
	private SendFriendVerifyTaskWebsocketHandler  sendFriendVerifyTaskWebsocketHandler;
	@Autowired
	private TriggerConversationPushTaskWebsocketHandler  triggerConversationPushTaskWebsocketHandler;
	@Autowired
	private WechatSettingTaskWebsocketHandler  wechatSettingTaskWebsocketHandler;
	@Autowired
	private PullFriendAddReqListTaskWebsocketHandler  pullFriendAddReqListTaskWebsocketHandler;
	@Autowired
	private TriggerBizContactPushTaskWebsocketHandler  triggerBizContactPushTaskWebsocketHandler;
	@Autowired
	private RemittanceTaskWebsocketHandler remittanceTaskWebsocketHandler;
	@Autowired
	private QueryHbDetailTaskWebsocketHandler queryHbDetailTaskWebsocketHandler;
	@Autowired
	private AddFriendWithSceneTaskWebsocketHandler  addFriendWithSceneTaskWebsocketHandler;
	@Autowired
	private JoinGroupByQrTaskWebsocketHandler joinGroupByQrTaskWebsocketHandler;
	
	
	///////////////////////////自定义的方法/////////////////////////////
	@Autowired
	private AddTaskTimeInfoWebsocketHandler  addTaskTimeInfoWebsocketHandler;
	@Autowired
	private GetCommonTagsWebsocketHandler  getCommonTagsWebsocketHandler;
	@Autowired
	private GetCommonTermsWebsocketHandler getCommonTermsWebsocketHandler;
	@Autowired
	private GetWechatFriendListWebsocketHandler getWechatFriendListWebsocketHandler;
	@Autowired
	private GetWechatFriendDetailWebsocketHandler  getWechatFriendDetailWebsocketHandler;
	@Autowired
	private QueryHistoryMessageWebsocketHandler  queryHistoryMessageWebsocketHandler;
	@Autowired
	private HistoryMessageListWebsocketHandler  historyMessageListWebsocketHandler;
	@Autowired
	private AutoTaskDetailListWebsocketHandler  autoTaskDetailListWebsocketHandler;
	@Autowired
	private AutoTaskUpdateWebsocketHandler  autoTaskUpdateWebsocketHandler;
	@Autowired
	private TriggerWechatPushTaskWebsocketHandler  triggerWechatPushTaskWebsocketHandler;
	@Autowired
	private SendMultiPictureTaskWebsocketHandler  sendMultiPictureTaskWebsocketHandler;
	@Autowired
	private ForwardMultiMessageTaskWebsocketHandler  forwardMultiMessageTaskWebsocketHandler;
	@Autowired
	private AutoFriendAddTaskWebsocketHandler autoFriendAddTaskWebsocketHandler;
	@Autowired
	private GetAutoFriendAddTaskListWebsocketHandler getAutoFriendAddTaskListWebsocketHandler;
	@Autowired
	private GetPhoneNumberListWebsocketHandler getPhoneNumberListWebsocketHandler;

	
	public void handler(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		String text = msg.text();
		if (!StringUtils.isEmpty(text)) {
			try {
				JSONObject jsonObject = JSONObject.parseObject(text);
				Object objMsgType = jsonObject.get("MsgType");
				if (null != objMsgType) {
					TransportMessage.Builder builder = TransportMessage.newBuilder();
					try {
					    String jsonFormat = jsonObject.toJSONString();
						JsonFormat.merge(jsonFormat, builder);
					} catch (Exception e) {
						log.debug("传入参数==="+jsonObject);
						log.debug("websocket传入json字符串转换proto失败！！");
					}
					TransportMessage vo = builder.build();
					String contentJsonStr = jsonObject.getString("Content"); 
					switch (objMsgType.toString()) {// 消息类型
						case "HeartBeatReq": {// 客户端发送的心跳包
							log.debug("websocket:msgtype=HeartBeatReq。。。。。");
							heartBeatReqWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "MsgReceivedAck": {// 消息接收确认回复
							log.debug("websocket:msgtype=MsgReceivedAck。。。。。");
							msgReceivedAckWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "DeviceAuthReq": {// 设备(客服客户端)获取通信token请求
							log.debug("websocket:msgtype=DeviceAuthReq。。。。。");
							deviceAuthReqWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "AccountForceOfflineNotice": {// 账号强制下线通知(用不到)
							log.debug("websocket:msgtype=AccountForceOfflineNotice。。。。。");
							break;
						}
						case "GetWeChatsReq": {// 拉取当前微信个人号列表请求（立即）
							log.debug("websocket:msgtype=GetWeChatsReq。。。。。");
							getWeChatsReqWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "AccountLogoutNotice": {// 客户端退出通知
							log.debug("websocket:msgtype=AccountLogoutNotice。。。。。");
							accountLogoutNoticeWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "WeChatLoginNotice": {// 客户端选择微信号登陆/登出通知
							log.debug("websocket:msgtype=WeChatLoginNotice。。。。。");
							weChatLoginNoticeWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "TalkToFriendTask": {// 给好友发消息任务
							log.debug("websocket:msgtype=TalkToFriendTask。。。。。");
							talkToFriendTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "RequestTalkDetailTask": {// 请求图片或视频消息的详细内容
							log.debug("websocket:msgtype=RequestTalkDetailTask。。。。。");
							requestTalkDetailTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "AddFriendsTask": {// 主动添加好友任务
							log.debug("websocket:msgtype=AddFriendsTask。。。。。");
							addFriendsTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "PostSNSNewsTask": {// 发送朋友圈任务
							log.debug("websocket:msgtype=PostSNSNewsTask。。。。。");
							postSNSNewsTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "DeleteSNSNewsTask": {// 删除朋友圈
							log.debug("websocket:msgtype=DeleteSNSNewsTask。。。。。");
							deleteSNSNewsTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "AcceptFriendAddRequestTask": {// 客户端或者服务端接受好友请求通知
							log.debug("websocket:msgtype=AcceptFriendAddRequestTask。。。。。");
							acceptFriendAddRequestTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "WeChatGroupSendTask": {// 群发消息任务
							log.debug("websocket:msgtype=WeChatGroupSendTask。。。。。");
							weChatGroupSendTaskWesocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "WeChatMaintenanceTask": {// 执行养号动作命令
							log.debug("websocket:msgtype=WeChatMaintenanceTask。。。。。");
							weChatMaintenanceTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "PostStopWeChatMaintenanceTask": {// 养号任务停止
							log.debug("websocket:msgtype=PostStopWeChatMaintenanceTask。。。。。");
							postStopWeChatMaintenanceTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerMessageReadTask": {// 通知手机将某个聊天窗口置为已读
							log.debug("websocket:msgtype=TriggerMessageReadTask。。。。。");
							triggerMessageReadTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PostFriendDetectTask": {// 清粉任务
							log.debug("websocket:msgtype=PostFriendDetectTask。。。。。");
							postFriendDetectTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PostStopFriendDetectTask": {// 终止清粉任务
							log.debug("websocket:msgtype=PostStopFriendDetectTask。。。。。");
							postStopFriendDetectTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PostDeleteDeviceNotice": {// 删除设备通知(没用到)
							log.debug("websocket:msgtype=PostDeleteDeviceNotice。。。。。");
							break;
						}
						case "TriggerFriendPushTask": {// 触发手机推送好友列表任务
							log.debug("websocket:msgtype=TriggerFriendPushTask。。。。。");
							triggerFriendPushTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "TriggerCirclePushTask": {// 触发手机推送朋友圈列表任务
							log.debug("websocket:msgtype=TriggerCirclePushTask。。。。。");
							triggerCirclePushTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "PostMomentsPraiseTask": {// 朋友圈点赞任务
							log.debug("websocket:msgtype=PostMomentsPraiseTask。。。。。");
							postMomentsPraiseTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PostStopMomentsPraiseTask": {// 停止朋友圈点赞任务
							log.debug("websocket:msgtype=PostStopMomentsPraiseTask。。。。。");
							postStopMomentsPraiseTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "CircleCommentDeleteTask": {// 朋友圈评论删除任务
							log.debug("websocket:msgtype=CircleCommentDeleteTask。。。。。");
							circleCommentDeleteTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "CircleCommentReplyTask": {// 朋友圈评论回复任务
							log.debug("websocket:msgtype=CircleCommentReplyTask。。。。。");
							circleCommentReplyTaskWebsocketHandler.handleMsg(ctx, vo,contentJsonStr);
							break;
						}
						case "RevokeMessageTask": {//  消息撤回
							log.debug("websocket:msgtype=RevokeMessageTask。。。。。");
							revokeMessageTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ForwardMessageTask": {//  转发消息
							log.debug("websocket:msgtype=ForwardMessageTask。。。。。");
							forwardMessageTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerHistoryMsgPushTask": {//通知手机推送聊天记录  
							log.debug("websocket:msgtype=TriggerHistoryMsgPushTask。。。。。");
							triggerHistoryMsgPushTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PullChatRoomQrCodeTask": {// 获取群聊二维码 
							log.debug("websocket:msgtype=PullChatRoomQrCodeTask。。。。。");
							pullChatRoomQrCodeTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ModifyFriendMemoTask": {// 修改备注任务
							log.debug("websocket:msgtype=ModifyFriendMemoTask。。。。。");
							modifyFriendMemoTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TakeLuckyMoneyTask": {//领取红包或转账
							log.debug("websocket:msgtype=TakeLuckyMoneyTask。。。。。");
							takeLuckyMoneyTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PullFriendCircleTask": {// 获取指定好友朋友圈
							log.debug("websocket:msgtype=PullFriendCircleTask。。。。。");
							pullFriendCircleTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PullCircleDetailTask": {// 获取朋友圈图片
							log.debug("websocket:msgtype=PullCircleDetailTask。。。。。");
							pullCircleDetailTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "CircleLikeTask": {// 单条朋友圈点赞任务
							log.debug("websocket:msgtype=CircleLikeTask。。。。。");
							circleLikeTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerChatroomPushTask": {// 触发手机推送群聊列表
							log.debug("websocket:msgtype=TriggerChatroomPushTask。。。。。");
							triggerChatroomPushTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "RequestChatRoomInfoTask": {// 请求具体群聊的详细信息
							log.debug("websocket:msgtype=RequestChatRoomInfoTask。。。。。");
							requestChatRoomInfoTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "RequestContactsInfoTask": {//  获取联系人详细信息（不一定是好友，如群聊成员）
							log.debug("websocket:msgtype=RequestContactsInfoTask。。。。。");
							requestContactsInfoTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ChatRoomActionTask": {// 群聊管理
							log.debug("websocket:msgtype=ChatRoomActionTask。。。。。");
							chatRoomActionTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "AddFriendInChatRoomTask": {// 群内加好友
							log.debug("websocket:msgtype=AddFriendInChatRoomTask。。。。。");
							addFriendInChatRoomTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "AddFriendFromPhonebookTask": {//通讯录加好友 
							log.debug("websocket:msgtype=AddFriendFromPhonebookTask。。。。。");
							addFriendFromPhonebookTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "DeleteFriendTask": {//删除好友
							log.debug("websocket:msgtype=DeleteFriendTask。。。。。");
							deleteFriendTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "SendLuckyMoneyTask": {//发红包 
							log.debug("websocket:msgtype=SendLuckyMoneyTask。。。。。");
							sendLuckyMoneyTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "RequestTalkContentTask": {// 获取聊天消息的原始内容（主要是xml内容）
							log.debug("websocket:msgtype=RequestTalkContentTask。。。。。");
							requestTalkContentTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ForwardMessageByContentTask": {//转发消息内容
							log.debug("websocket:msgtype=ForwardMessageByContentTask。。。。。");
							forwardMessageByContentTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PullWeChatQrCodeTask": {//主动要求手机上传当前登录的微信二维码
							log.debug("websocket:msgtype=PullWeChatQrCodeTask。。。。。");
							pullWeChatQrCodeTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						
                        case "ChatRoomInviteApproveTask": {//25、群主通过入群申请
							log.debug("websocket:msgtype=ChatRoomInviteApproveTask。。。。。");
							chatRoomInviteApproveTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "WechatLogoutTask": {//26、微信账号登出
							log.debug("websocket:msgtype=WechatLogoutTask。。。。。");
							wechatLogoutTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PhoneActionTask": {//27、手机操作指令
							log.debug("websocket:msgtype=PhoneActionTask。。。。。");
							phoneActionTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ContactLabelTask": {//28、设置联系人标签
							log.debug("websocket:msgtype=ContactLabelTask。。。。。");
							contactLabelTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ContactLabelDeleteTask": {//29、删除标签
							log.debug("websocket:msgtype=ContactLabelDeleteTask。。。。。");
							contactLabelDeleteTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "VoiceTransTextTask": {//30、语音消息转文字
							log.debug("websocket:msgtype=VoiceTransTextTask。。。。。");
							voiceTransTextTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "FindContactTask": {//31、查找微信联系人
							log.debug("websocket:msgtype=FindContactTask 。。。。。");
							findContactTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "AgreeJoinChatRoomTask": {//33、同意加入群聊
							log.debug("websocket:msgtype=AgreeJoinChatRoomTask 。。。。。");
							agreeJoinChatRoomTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ClearAllChatMsgTask": {//34、清空聊天记录
							log.debug("websocket:msgtype=ClearAllChatMsgTask 。。。。。");
							clearAllChatMsgTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "SendFriendVerifyTask": {//35、聊天界面发送朋友验证
							log.debug("websocket:msgtype=SendFriendVerifyTask 。。。。。");
							sendFriendVerifyTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerConversationPushTask": {//36、会话列表推送
							log.debug("websocket:msgtype=TriggerConversationPushTask  。。。。。");
							triggerConversationPushTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "WechatSettingTask": {//37、微信设置：改昵称，头像
							log.debug("websocket:msgtype=WechatSettingTask  。。。。。");
							wechatSettingTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "PullFriendAddReqListTask": {//38、获取加好友请求列表
							log.debug("websocket:msgtype=PullFriendAddReqListTask  。。。。。");
							pullFriendAddReqListTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerBizContactPushTask": {//39、获取公众号列表
							log.debug("websocket:msgtype=TriggerBizContactPushTask  。。。。。");
							triggerBizContactPushTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "RemittanceTask": {//转账
							log.debug("websocket:msgtype=remittanceTask  。。。。。");
							remittanceTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "TriggerWechatPushTask": {//触发微信上线通知，用于更新微信账号的信息
							log.debug("websocket:msgtype=TriggerWechatPushTask  。。。。。");
							triggerWechatPushTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "SendMultiPictureTask": {//聊天发送多张图片
							log.debug("websocket:msgtype=SendMultiPictureTask  。。。。。");
							sendMultiPictureTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "ForwardMultiMessageTask": {//转发多条聊天消息（逐条转发）
							log.debug("websocket:msgtype=forwardMultiMessageTask  。。。。。");
							forwardMultiMessageTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "QueryHbDetailTask": {//查询红包详情
							log.debug("websocket:msgtype=QueryHbDetailTask  。。。。。");
							queryHbDetailTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						
						case "AddFriendWithSceneTask": {//各场景加好友
							log.debug("websocket:msgtype=AddFriendWithSceneTask  。。。。。");
							addFriendWithSceneTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "JoinGroupByQrTask": {//扫二维码加群
							log.debug("websocket:msgtype=JoinGroupByQrTask  。。。。。");
							joinGroupByQrTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						 
						 
						/////////////////////自定义的方法///////////////////////////////
						case "AutoFriendAddTask": {//自动添加好友
							log.debug("websocket:msgtype=AutoFriendAddTask。。。。。");
							autoFriendAddTaskWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetAutoFriendAddTaskList": {//获取自动添加好友任务列表
							log.debug("websocket:msgtype=GetAutoFriendAddTaskList。。。。。");
							getAutoFriendAddTaskListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetPhoneNumberList": {//获取电话号码列表
							log.debug("websocket:msgtype=GetPhoneNumberList。。。。。");
							getPhoneNumberListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						
						case "AddTaskTimeInfo": {//添加定时任务
							log.debug("websocket:msgtype=AddTaskTimeInfo。。。。。");
							addTaskTimeInfoWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetTaskInfoList": {//获取任务列表
							log.debug("websocket:msgtype=GetTaskInfoList。。。。。");
							getTaskInfoListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetCommonTags": {//获取公共的标签
							log.debug("websocket:msgtype=GetCommonTags。。。。。");
							getCommonTagsWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetCommonTerms": {//获取公共的术语
							log.debug("websocket:msgtype=GetCommonTerms。。。。。");
							getCommonTermsWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetWechatFriendList": {//获取微信好友列表
							log.debug("websocket:msgtype=GetWechatFriendList。。。。。");
							getWechatFriendListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "GetWechatFriendDetail": {//获取微信好友详细信息
							log.debug("websocket:msgtype=GetWechatFriendDetail。。。。。");
							getWechatFriendDetailWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "QueryHistoryMessage": {//查询服务端消息对话记录
							log.debug("websocket:msgtype=QueryHistoryMessage。。。。。");
							queryHistoryMessageWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "HistoryMessageList": {//查询离线历史消息记录
							log.debug("websocket:msgtype=HistoryMessageList。。。。。");
							historyMessageListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "AutoTaskDetailList": {//自动任务详情列表
							log.debug("websocket:msgtype=AutoTaskDetailList。。。。。");
							autoTaskDetailListWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "AutoTaskUpdate": {//自动任务更新
							log.debug("websocket:msgtype=AutoTaskUpdate。。。。。");
							autoTaskUpdateWebsocketHandler.handleMsg(ctx, vo, contentJsonStr);
							break;
						}
						case "Error": {// 将错误单独提升为一种消息类型
							log.debug("websocket:msgtype=Error。。。。。");
							break;
						}
						default: {
							log.debug("websocket:msgtype=UnknownMsg - 没有找到消息处理器！！");
							break;
						}
					}
				} else {
					log.debug("消息类型传入错误！");
					ctx.channel().writeAndFlush(new TextWebSocketFrame("消息类型传入错误！"));
				}
			} catch (Exception e) {
				log.debug("参数传入错误！");
				e.printStackTrace();
				ctx.channel().writeAndFlush(new TextWebSocketFrame("参数传入错误！"));
			}
		}
		text = null;//清空一下
	}
	
	
	//如果觉得上面代码太low，可以用下面的注入方式，注意每个handler要实现接口才行
	/*
	@Autowired
	private Map<String, JsonMessageHandler> handlers;

	public void handler(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		String text = msg.text();
		if (!StringUtils.isEmpty(text)) {
			try {
				JSONObject jsonObject = JSONObject.parseObject(text);
				Object objMsgType = jsonObject.get("MsgType");
				if (null != objMsgType) {
					TransportMessage.Builder builder = TransportMessage.newBuilder();
					try {
						String jsonFormat = jsonObject.toJSONString();
						JsonFormat.merge(jsonFormat, builder);
					} catch (Exception e) {
						log.error("websocket传入json字符串转换proto失败！传入参数===" + jsonObject);
					}
					TransportMessage vo = builder.build();
					String contentJsonStr = jsonObject.getString("Content");

					String msgtype = StringUtil.toLowerCaseFirstOne(objMsgType.toString() + "WebsocketHandler");
					log.debug("websocket:" + msgtype);
					if (handlers.containsKey(msgtype)) {
						handlers.get(msgtype).handleMsg(ctx, vo, contentJsonStr);
					} else {
						log.error("消息类型传入错误！"+msgtype);
					}
				} else {
					log.error("消息类型传入错误！");
					ctx.channel().writeAndFlush(new TextWebSocketFrame("消息类型传入错误！"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("参数传入错误！"+e.getMessage());
				ctx.channel().writeAndFlush(new TextWebSocketFrame("参数传入错误！"));
			}
		}
		text = null;// 清空一下
	}
	*/
	
}
