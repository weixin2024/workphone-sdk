package com.jubotech.framework.netty.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubotech.framework.netty.handler.socket.BizContactPushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatMsgFilePushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatRoomAddNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatRoomChangedNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatRoomDelNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatRoomMembersNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ChatroomPushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleCommentDeleteTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleCommentNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleCommentReplyTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleDelNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleDetailNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleLikeNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CircleNewPublishNoticeHandler;
import com.jubotech.framework.netty.handler.socket.CirclePushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ContactLabelAddNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ContactLabelDelNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ContactLabelInfoNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ContactsInfoNoticeHandler;
import com.jubotech.framework.netty.handler.socket.ConversationPushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.DeviceAuthReqHandler;
import com.jubotech.framework.netty.handler.socket.ErrorHandler;
import com.jubotech.framework.netty.handler.socket.FindContactTaskResultHandler;
import com.jubotech.framework.netty.handler.socket.FriendAddNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendAddReqListNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendAddReqeustNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendChangeNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendDelNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendPushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.FriendTalkNoticeHandler;
import com.jubotech.framework.netty.handler.socket.HeartBeatReqHandler;
import com.jubotech.framework.netty.handler.socket.HistoryMsgPushNoticeHandler;
import com.jubotech.framework.netty.handler.socket.MsgReceivedAckHandler;
import com.jubotech.framework.netty.handler.socket.PostDeviceInfoNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PostFriendDetectCountNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PostMessageReadNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PostMomentsPraiseCountNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PostSNSNewsTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PullChatRoomQrCodeTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.PullWeChatQrCodeTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.QueryHbDetailTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.RequestTalkContentTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.RequestTalkDetailTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.TakeMoneyTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.TalkToFriendTaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.TaskResultNoticeHandler;
import com.jubotech.framework.netty.handler.socket.WeChatOfflineNoticeHandler;
import com.jubotech.framework.netty.handler.socket.WeChatOnlineNoticeHandler;
import com.jubotech.framework.netty.handler.socket.WeChatTalkToFriendNoticeHandler;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

/**
 * ?????????????????????
 */

@Service
public class SocketMessageProcessor {
	
	private static final Logger log = LoggerFactory.getLogger(SocketMessageProcessor.class);
	
	@Autowired
	private DeviceAuthReqHandler deviceAuthReqHandler;
	@Autowired
	private HeartBeatReqHandler heartBeatReqHandler;
	@Autowired
	private WeChatOnlineNoticeHandler  weChatOnlineNoticeHandler;
	@Autowired
	private WeChatOfflineNoticeHandler  weChatOfflineNoticeHandler;
	@Autowired
	private FriendTalkNoticeHandler  friendTalkNoticeHandler;
	@Autowired
	private TaskResultNoticeHandler taskResultNoticeHandler;
	@Autowired
	private FriendAddNoticeHandler friendAddNoticeHandler;
	@Autowired
	private FriendDelNoticeHandler friendDelNoticeHandler;
	@Autowired
	private MsgReceivedAckHandler  msgReceivedAckHandler;
	@Autowired
	private WeChatTalkToFriendNoticeHandler  weChatTalkToFriendNoticeHandler;
	@Autowired
	private FriendAddReqeustNoticeHandler  friendAddReqeustNoticeHandler;
	@Autowired
	private TalkToFriendTaskResultNoticeHandler  talkToFriendTaskResultNoticeHandler;
	@Autowired
	private RequestTalkDetailTaskResultNoticeHandler  requestTalkDetailTaskResultNoticeHandler;
	@Autowired
	private PullWeChatQrCodeTaskResultNoticeHandler  pullWeChatQrCodeTaskResultNoticeHandler;
	@Autowired
	private CircleNewPublishNoticeHandler  circleNewPublishNoticeHandler;
	@Autowired
	private CircleDelNoticeHandler  circleDelNoticeHandler;
	@Autowired
	private CircleLikeNoticeHandler circleLikeNoticeHandler;
	@Autowired
	private CircleCommentNoticeHandler  circleCommentNoticeHandler;
	@Autowired
	private CircleCommentReplyTaskResultNoticeHandler circleCommentReplyTaskResultNoticeHandler;
	@Autowired
	private PostMessageReadNoticeHandler  postMessageReadNoticeHandler;
	@Autowired
	private PostSNSNewsTaskResultNoticeHandler  postSNSNewsTaskResultNoticeHandler;
	@Autowired
	private FriendPushNoticeHandler  friendPushNoticeHandler;
	@Autowired
	private PostFriendDetectCountNoticeHandler  postFriendDetectCountNoticeHandler;
	@Autowired
	private CirclePushNoticeHandler  circlePushNoticeHandler;
	@Autowired
	private PostMomentsPraiseCountNoticeHandler postMomentsPraiseCountNoticeHandler;
	@Autowired
	private CircleCommentDeleteTaskResultNoticeHandler circleCommentDeleteTaskResultNoticeHandler;
	@Autowired
	private CircleDetailNoticeHandler circleDetailNoticeHandler;
	@Autowired
	private ContactsInfoNoticeHandler contactsInfoNoticeHandler;
	@Autowired
	private ChatRoomAddNoticeHandler chatRoomAddNoticeHandler;
	@Autowired
	private ContactLabelAddNoticeHandler contactLabelAddNoticeHandler;
	@Autowired
	private ContactLabelDelNoticeHandler contactLabelDelNoticeHandler;
	@Autowired
	private TakeMoneyTaskResultNoticeHandler takeMoneyTaskResultNoticeHandler;
	@Autowired
	private ChatRoomDelNoticeHandler chatRoomDelNoticeHandler;
	@Autowired
	private ChatRoomChangedNoticeHandler  chatRoomChangedNoticeHandler;
	@Autowired
	private PullChatRoomQrCodeTaskResultNoticeHandler pullChatRoomQrCodeTaskResultNoticeHandler;
	@Autowired
	private ChatroomPushNoticeHandler chatroomPushNoticeHandler;
	@Autowired
	private ContactLabelInfoNoticeHandler contactLabelInfoNoticeHandler;
	@Autowired
	private HistoryMsgPushNoticeHandler historyMsgPushNoticeHandler;
	@Autowired
	private ChatRoomMembersNoticeHandler chatRoomMembersNoticeHandler;
	@Autowired
	private RequestTalkContentTaskResultNoticeHandler requestTalkContentTaskResultNoticeHandler;
	@Autowired
	private FindContactTaskResultHandler findContactTaskResultHandler;
	@Autowired
	private ConversationPushNoticeHandler conversationPushNoticeHandler;
	@Autowired
	private FriendAddReqListNoticeHandler friendAddReqListNoticeHandler;
	@Autowired
	private BizContactPushNoticeHandler bizContactPushNoticeHandler;
	@Autowired
	private PostDeviceInfoNoticeHandler postDeviceInfoNoticeHandler;
	@Autowired
	private ChatMsgFilePushNoticeHandler chatMsgFilePushNoticeHandler;
	@Autowired
	private QueryHbDetailTaskResultNoticeHandler queryHbDetailTaskResultNoticeHandler;
	@Autowired
	private FriendChangeNoticeHandler friendChangeNoticeHandler;
	
	@Autowired
	private ErrorHandler  errorHandler;

	public  void  handler(ChannelHandlerContext ctx, Object msg) {
		TransportMessage msgVo = (TransportMessage) msg;
		switch (msgVo.getMsgType()) {
		case HeartBeatReq: {// ???????????????????????????
			log.debug("socket:msgtype=HeartBeatReq");
			heartBeatReqHandler.handleMsg(ctx, msgVo);
			break;
		}
		case MsgReceivedAck: {//???????????????????????????????????????????????????
			log.debug("socket:msgtype=MsgReceivedAck");
			msgReceivedAckHandler.handleMsg(ctx, msgVo);
			break;
		}
		case DeviceAuthReq: {// ?????????????????????  ??????(?????????????????????????????????)????????????token??????
			log.debug("socket:msgtype=DeviceAuthReq");
			deviceAuthReqHandler.handleMsg(ctx, msgVo);
			break;
		}
		case WeChatOnlineNotice: {// ?????????????????????????????????
			log.debug("socket:msgtype=WeChatOnlineNotice");
			weChatOnlineNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
		case WeChatOfflineNotice: {// ?????????????????????????????????
			log.debug("socket:msgtype=WeChatOfflineNotice");
			weChatOfflineNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
		case FriendTalkNotice: {// ??????????????????????????????
			log.debug("socket:msgtype=FriendTalkNotice");
			friendTalkNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
		case TaskResultNotice: {// ????????????????????????
			log.debug("socket:msgtype=TaskResultNotice");
			taskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
		case WeChatTalkToFriendNotice: {// ????????????????????????????????????
			log.debug("socket:msgtype=WeChatTalkToFriendNotice");
			weChatTalkToFriendNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case FriendAddReqeustNotice: {//????????????????????????????????????
        	log.debug("socket:msgtype=FriendAddReqeustNotice");
        	friendAddReqeustNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case FriendAddNotice: {// ?????????????????????????????????
        	log.debug("socket:msgtype=FriendAddNotice");
			friendAddNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case FriendDelNotice: {// ?????????????????????????????????
        	log.debug("socket:msgtype=FriendDelNotice");
			friendDelNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case TalkToFriendTaskResultNotice: {//?????????????????????????????????????????????
        	log.debug("socket:msgtype=TalkToFriendTaskResultNotice");
        	talkToFriendTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case RequestTalkDetailTaskResultNotice : {//??????????????????????????????????????????
        	log.debug("socket:msgtype=RequestTalkDetailTaskResultNotice");
        	requestTalkDetailTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PullWeChatQrCodeTaskResultNotice : {//??????????????????????????????????????????
        	log.debug("socket:msgtype=PullWeChatQrCodeTaskResultNotice");
        	pullWeChatQrCodeTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		} 
        case  CircleNewPublishNotice : {//?????????????????????????????????
        	log.debug("socket:msgtype=CircleNewPublishNotice");
        	circleNewPublishNoticeHandler.handleMsg(ctx, msgVo);
			break;
		} 
        case  CircleDelNotice : {//??????????????????????????????
        	log.debug("socket:msgtype=CircleDelNotice");
        	circleDelNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  CircleLikeNotice : {//???????????????????????????/??????????????????
        	log.debug("socket:msgtype=CircleLikeNotice");
        	circleLikeNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  CircleCommentNotice  : {//???????????????????????????/?????????????????????
        	log.debug("socket:msgtype=CircleCommentNotice");
        	circleCommentNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  CircleCommentDeleteTaskResultNotice  : {//?????????????????????????????????
        	log.debug("socket:msgtype=CircleCommentDeleteTaskResultNotice");
        	circleCommentDeleteTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
 
        case  CircleCommentReplyTaskResultNotice  : {//????????????????????????????????????????????????????????????
        	log.debug("socket:msgtype=CircleCommentReplyTaskResultNotice");
      	    circleCommentReplyTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		} 
        case  PostSNSNewsTaskResultNotice   : {//?????????????????????????????????????????????????????????
        	log.debug("socket:msgtype=PostSNSNewsTaskResultNotice");
      	    postSNSNewsTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PostMessageReadNotice  : {//??????????????????????????????
        	log.debug("socket:msgtype=PostMessageReadNotice");
        	postMessageReadNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ContactsInfoNotice  : {// ?????????????????????
        	log.debug("socket:msgtype=ContactsInfoNotice");
        	contactsInfoNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatRoomAddNotice  : {//??????????????????
        	log.debug("socket:msgtype=ChatRoomAddNotice");
        	chatRoomAddNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ContactLabelAddNotice  : {//????????????????????????????????????
        	log.debug("socket:msgtype=ContactLabelAddNotice");
        	contactLabelAddNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ContactLabelDelNotice  : {//???????????????????????????
        	log.debug("socket:msgtype=ContactLabelAddNotice");
        	contactLabelDelNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  TakeMoneyTaskResultNotice  : {//??????????????????????????????
        	log.debug("socket:msgtype=TakeMoneyTaskResultNotice");
        	takeMoneyTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  CircleDetailNotice  : {//?????????????????????
        	log.debug("socket:msgtype=CircleDetailNotice");
        	circleDetailNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatRoomDelNotice  : {//??????????????????
        	log.debug("socket:msgtype=ChatRoomDelNotice");
        	chatRoomDelNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatRoomChangedNotice  : {//????????????????????????
        	log.debug("socket:msgtype=ChatRoomChangedNotice");
        	chatRoomChangedNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PullChatRoomQrCodeTaskResultNotice  : {//????????????
        	log.debug("socket:msgtype=PullChatRoomQrCodeTaskResultNotice");
        	pullChatRoomQrCodeTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  FriendPushNotice   : {//???????????????????????????
        	log.debug("socket:msgtype=FriendPushNotice");
        	friendPushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PostDeviceInfoNotice    : {//?????????????????????????????????(????????????)
        	log.debug("socket:msgtype=PostDeviceInfoNotice");
        	System.out.println("PostDeviceInfoNotice...");
        	postDeviceInfoNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PostFriendDetectCountNotice   : {//???????????????????????????????????????
        	log.debug("socket:msgtype=PostFriendDetectCountNotice");
        	postFriendDetectCountNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  CirclePushNotice: {//???????????????????????????
        	log.debug("socket:msgtype=CirclePushNotice");
        	circlePushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  PostMomentsPraiseCountNotice: {//?????????????????????????????????
        	log.debug("socket:msgtype=PostMomentsPraiseCountNotice");
        	postMomentsPraiseCountNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatroomPushNotice: {// ???????????????????????????
        	log.debug("socket:msgtype=ChatroomPushNotice");
        	chatroomPushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ContactLabelInfoNotice: {// ???????????????????????????
        	log.debug("socket:msgtype=ContactLabelInfoNotice");
        	contactLabelInfoNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  HistoryMsgPushNotice: {// ??????????????????
        	log.debug("socket:msgtype=HistoryMsgPushNotice");
        	historyMsgPushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatRoomMembersNotice: {// ?????????????????????????????? 
        	log.debug("socket:msgtype=ChatRoomMembersNotice");
        	chatRoomMembersNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  RequestTalkContentTaskResultNotice: {// ?????????????????????????????????
        	log.debug("socket:msgtype=RequestTalkContentTaskResultNotice");
        	requestTalkContentTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ChatMsgFilePushNotice: {// ?????????????????????????????????????????????
        	log.debug("socket:msgtype=ChatMsgFilePushNotice");
        	chatMsgFilePushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  FindContactTaskResult: {// 32??????????????????????????????
        	log.debug("socket:msgtype=FindContactTaskResult");
        	findContactTaskResultHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  ConversationPushNotice : {// ??????????????????
        	log.debug("socket:msgtype=FindContactTaskResult");
        	conversationPushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  FriendAddReqListNotice : {// ?????????????????????
        	log.debug("socket:msgtype=FriendAddReqListNotice");
        	friendAddReqListNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  BizContactPushNotice : {// ?????????????????????
        	log.debug("socket:msgtype=BizContactPushNotice");
        	bizContactPushNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  QueryHbDetailTaskResultNotice : {// ??????????????????
        	log.debug("socket:msgtype=QueryHbDetailTaskResultNotice");
        	queryHbDetailTaskResultNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
        case  FriendChangeNotice : {// ????????????????????????
        	log.debug("socket:msgtype=FriendChangeNotice");
        	friendChangeNoticeHandler.handleMsg(ctx, msgVo);
			break;
		}
         
		case Error: {// ??????
			log.debug("socket:msgtype=Error");
			errorHandler.handleMsg(ctx, msgVo);
			break;
		}
		default:
			log.debug("socket:msgtype=UnknownMsg - ?????????????????????????????????");
			break;
		} 
		msgVo = null;
	}
	

	//???????????????????????????low????????????????????????????????????????????????handler?????????????????????
	/*
	@Autowired
	private  Map<String,MessageHandler> handlers;
	 
	public  void  handler(ChannelHandlerContext ctx, Object msg) {
		TransportMessage transportMessage = (TransportMessage) msg;
		String type = StringUtil.toLowerCaseFirstOne(transportMessage.getMsgType().toString()+"Handler");
		log.debug("socket:"+type);
		if(handlers.containsKey(type)) {
			handlers.get(type).handleMsg(ctx, transportMessage);
		}else {
			log.error("not find msgtype"+type);
		}
		msg = null;
	}
	*/
	
}
