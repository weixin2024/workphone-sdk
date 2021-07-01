package com.jubotech.framework.netty.handler.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatOfflineNotice.WeChatOfflineNoticeMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class WeChatOfflineNoticeHandler {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxAccountService weChatAccountService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AsyncTaskService asyncTaskService;

	/**
	 * 手机客户端微信下线通知
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
		try {
			WeChatOfflineNoticeMessage req = vo.getContent().unpack(WeChatOfflineNoticeMessage.class);
			log.debug(JsonFormat.printer().print(req));
			if (null != req) {
				// 把消息转发给pc端
				WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
				if (null != account && null != account.getAccountid()) {

					AccountInfo accInfo = accountService.findAccountInfoByid(account.getAccountid());
					if (null != accInfo) {
						account.setIsonline(1);// 下线
						weChatAccountService.updateOnline(account);
					}
					asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.WeChatOfflineNotice, req);

				}

				// 3、告诉客户端消息已收到
				MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
			} else {
				MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam, vo.getId(), Constant.ERROR_MSG_ILLEGALDEVICE);
			}

		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam, vo.getId(), Constant.ERROR_MSG_DECODFAIL);
		}
	}

}