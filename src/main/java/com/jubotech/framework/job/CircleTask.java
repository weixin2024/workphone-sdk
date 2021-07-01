package com.jubotech.framework.job;
 
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jubotech.business.web.domain.CircleInfo;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.CircleService;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;
import com.jubotech.framework.util.DateUtil;

import Jubo.JuLiao.IM.Wx.Proto.PullCircleDetailTask.PullCircleDetailTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.PullFriendCircleTask.PullFriendCircleTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import io.netty.channel.ChannelHandlerContext;
/*
//用到的时候在开
 */
//@Configuration
//@EnableScheduling
//@EnableAsync

public class CircleTask {
	
	private  final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private WxAccountService weChatAccountService;

	@Autowired
	private CircleService circleService;
	 
	/**
	 * 同步数据
	 */
//	@Async
//	@Scheduled(cron = "0 0/5 0-23 * * ?")//测试
	public void timeTaskExecute1() {
		try {
			String curName = Thread.currentThread().getName() ;
	        System.out.println("当前时间:"+LocalDateTime.now()+"  任务execute1对应的线程名: "+curName);
			log.info("CircleTask run by timeTaskExecute1");
			List<WxAccountInfo> accountList = weChatAccountService.findAllWeChatAccountInfo(0);// 查询上线的所有微信号
			if (null != accountList && accountList.size() > 0) {
				long date = (new Date().getTime()) / 1000;// 得到当前时间,单位秒
				for (int i = 0; i < accountList.size(); i++) {
					WxAccountInfo account = accountList.get(i);
					PullFriendCircleTaskMessage.Builder bd = PullFriendCircleTaskMessage.newBuilder();
					bd.setWeChatId(account.getWechatid());
					bd.setCount(2);// 最多条数，传0则全部
					bd.setRefTime(0);
					bd.setStartTime(date);
					PullFriendCircleTaskMessage req = bd.build();
					// 将消息转发送给手机客户端
					ChannelHandlerContext cx = NettyConnectionUtil
							.getClientChannelHandlerContextByUserId(account.getWechatid());
					if (null != cx) {
						MessageUtil.sendMsg(cx, EnumMsgType.PullFriendCircleTask, NettyConnectionUtil.getNettyId(cx), null,
								req);
					}

				}
			}
			
		} catch (Throwable e) {
			log.info("timeTaskExecute1  崩溃了");
			e.printStackTrace();
		}
}

	/**
	 * 获取朋友圈详情
	 */
	 
//	@Async
//	@Scheduled(cron = "0 0/11 0-23 * * ?")
	public void timeTaskExecute2() {
		try {
			String curName = Thread.currentThread().getName() ;
	        System.out.println("当前时间:"+LocalDateTime.now()+"  任务execute2对应的线程名: "+curName);
			 
			log.info("CircleTask run by timeTaskExecute2");
			String dat = DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_1);
			List<CircleInfo> circleList = circleService.queryCircleInfoByInserttime(dat);
			if (null != circleList && circleList.size() > 0) {
				for (int i = 0; i < circleList.size(); i++) {
					CircleInfo circle = circleList.get(i);
					PullCircleDetailTaskMessage.Builder bd = PullCircleDetailTaskMessage.newBuilder();
					bd.setWeChatId(circle.getSourcewechatid());
					bd.setCircleId(Long.valueOf(circle.getCircleid()));
					bd.setGetBigMap(true);
					PullCircleDetailTaskMessage req = bd.build();
					// 将消息转发送给手机客户端
					ChannelHandlerContext cx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(circle.getSourcewechatid());
					if (null != cx) {
						MessageUtil.sendMsg(cx, EnumMsgType.PullCircleDetailTask, NettyConnectionUtil.getNettyId(cx), null,req);
					}
				}

			}
		 
		} catch (Throwable e) {
			log.info("timeTaskExecute2  崩溃了");
			e.printStackTrace();
		}
		
	}
	
	
}
