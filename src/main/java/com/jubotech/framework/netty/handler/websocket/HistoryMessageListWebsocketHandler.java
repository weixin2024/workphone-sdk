package com.jubotech.framework.netty.handler.websocket;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.WxMessageInfo;
import com.jubotech.business.web.domain.req.HistoryMessageVo;
import com.jubotech.business.web.service.WxMessageService;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.util.DateUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class HistoryMessageListWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	 	
	@Autowired
	private WxMessageService  weChatMessageService;
	/** 
	 * 获取微信好友对话历史消息
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	HistoryMessageVo  req =  JSON.parseObject(contentJsonStr,HistoryMessageVo.class);
        	if(null == req || StringUtils.isEmpty(req.getStartTime()) ){
        		MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam,Constant.ERROR_MSG_PARAMERROR);
        		return;
        	}
        		
        	String  startTime = req.getStartTime();
			if("0".equals(startTime)){
				req.setStartTime(null);
			}else{
				Date date = new Date(Long.valueOf(startTime));
				String dat = DateUtil.convertDate2String(date, DateUtil.DATE_FORMAT_2);
				req.setStartTime(dat);
			}

			Integer totalResult =   weChatMessageService.queryHistormMessageCount(req);
			if(totalResult>0){
				Integer pageSize = 500;
				int pageTotal =1;//总共多少页
				if(totalResult > 500){
					pageTotal = totalResult % pageSize == 0 ? totalResult / pageSize : totalResult / pageSize + 1;
				}
				for(int pageNo=1;pageNo<=pageTotal;pageNo++){
					DBPage page = new DBPage(pageSize, (pageNo - 1) * pageSize);
					List<WxMessageInfo> resultList = weChatMessageService.queryHistormMessage(page,req);
					 
					PageBean<WxMessageInfo> pageBean = new PageBean<WxMessageInfo>(pageSize, pageNo,pageTotal, resultList);
					String json = null;
					if(null != pageBean && null != pageBean.getResultList() && pageBean.getResultList().size()>0){
						pageBean.setWeChatId(req.getWechatId());
						json = JSON.toJSONString(pageBean);
					}
	    			
	        		//3、告诉PC客户端消息已收到
	    			MessageUtil.sendCustomJsonMsg(ctx, "HistoryMessageListResp", json);
				}
			}else{
				PageBean<WxMessageInfo> pageBean = new PageBean<WxMessageInfo>(0, 0,0, null);
				String json = null;
				pageBean.setWeChatId(req.getWechatId());
				json = JSON.toJSONString(pageBean);
    			MessageUtil.sendCustomJsonMsg(ctx, "HistoryMessageListResp", json);
			}
			
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
    
}