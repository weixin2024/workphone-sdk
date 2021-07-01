package com.jubotech.framework.netty.utils;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.FriendAddTaskDetails;
import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.business.web.domain.TimeTaskDetails;

import Jubo.JuLiao.IM.Wx.Proto.AddFriendsTask.AddFriendsTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TalkToFriendTask.TalkToFriendTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.WeChatGroupSendTask.WeChatGroupSendTaskMessage;
import io.netty.channel.ChannelHandlerContext;

public class JsonToProtoConverterUtil {
	
	public static void sendProtoMsg(TaskTimeInfo task, TimeTaskDetails details) {
		if (task.getTasktype() == 1) {// 群发好友
			talkToFriendTaskMessage(details);
		} else if (task.getTasktype() == 2) {
			sendPostSNSNewsTaskMessage(details);
		} else if(task.getTasktype() == 5){//群发群
			sendGroupMessage(details);
		} 
	}
	
	
   public static void sendAddFriendsTaskMessage(FriendAddTaskDetails details){
	   try {
		    AddFriendsTaskMessage.Builder bd = AddFriendsTaskMessage.newBuilder();
			JsonFormat.parser().merge(details.getJson_content(), bd);
			AddFriendsTaskMessage req = bd.build();
			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(req.getWeChatId());
			if (null != chx) {
				// 发给手机端
				MessageUtil.sendMsg(chx, EnumMsgType.AddFriendsTask, null, null, req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
	
	private  static void sendGroupMessage(TimeTaskDetails details){
		try {
			TalkToFriendTaskMessage.Builder bd = TalkToFriendTaskMessage.newBuilder();
			JsonFormat.parser().merge(details.getJson_content(), bd);
			TalkToFriendTaskMessage req = bd.build();
			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(req.getWeChatId());
			if (null != chx) {
				// 发给手机端
				MessageUtil.sendMsg(chx, EnumMsgType.TalkToFriendTask, null, null, req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sendPostSNSNewsTaskMessage(TimeTaskDetails details) {
		try {
			PostSNSNewsTaskMessage.Builder bd = PostSNSNewsTaskMessage.newBuilder();
			JsonFormat.parser().merge(details.getJson_content(), bd);
			PostSNSNewsTaskMessage req = bd.build();

			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(req.getWeChatId());
			if (null != chx) {
				// 发给手机端
				MessageUtil.sendMsg(chx, EnumMsgType.PostSNSNewsTask, null, null, req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void sendWeChatGroupSendTaskMessage(TimeTaskDetails details) {
		try {
			WeChatGroupSendTaskMessage.Builder bd = WeChatGroupSendTaskMessage.newBuilder();
			JsonFormat.parser().merge(details.getJson_content(), bd);
			WeChatGroupSendTaskMessage req = bd.build();
			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(req.getWeChatId());
			if (null != chx) {
				// 发给手机端
				MessageUtil.sendMsg(chx, EnumMsgType.WeChatGroupSendTask, null, null, req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void talkToFriendTaskMessage(TimeTaskDetails details) {
		try {
			TalkToFriendTaskMessage.Builder bd = TalkToFriendTaskMessage.newBuilder();
			JsonFormat.parser().merge(details.getJson_content(), bd);
			TalkToFriendTaskMessage req = bd.build();
			ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(req.getWeChatId());
			if (null != chx) {
				// 发给手机端
				MessageUtil.sendMsg(chx, EnumMsgType.TalkToFriendTask, null, null, req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
