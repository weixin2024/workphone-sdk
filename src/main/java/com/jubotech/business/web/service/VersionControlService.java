package com.jubotech.business.web.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.VersionControlDao;
import com.jubotech.business.web.dao.WxAccountDao;
import com.jubotech.business.web.domain.VersionControl;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.domain.req.VersionControlVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.UpgradeDeviceAppNotice.DeviceAppUpgradeMessage;
import Jubo.JuLiao.IM.Wx.Proto.UpgradeDeviceAppNotice.UpgradeDeviceAppNoticeMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
@Transactional // 支持事务
public class VersionControlService {

	@Autowired
	private VersionControlDao versionControlDao;
	
	@Autowired
	private WxAccountDao wxAccountDao;

	public PageBean<VersionControl> queryVersionControl(VersionControlVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<VersionControl> resultList = versionControlDao.queryVersionControl(page,info);
		Integer totalResult = versionControlDao.queryVersionControlCount(info);
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<VersionControl> pageBean = new PageBean<VersionControl>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}

 
	public VersionControl queryVersionControlById(Integer id){
		return versionControlDao.queryVersionControlById(id);
	}
	
 
	
	public String insert(VersionControl info) {
		String res = "success";
		try {
			versionControlDao.insert(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public String update(VersionControl info) {
		String res = "success";
		try {
			versionControlDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public void delete(Integer id) {
		VersionControl info = new VersionControl();
		info.setId(id);
		versionControlDao.delete(info);
	}
	
	public void pushAppUpdate(Integer id){
		VersionControl  info = versionControlDao.queryVersionControlById(id);
		if(null != info){
			info.setFlag(0);
			versionControlDao.update(info);
			
			DeviceAppUpgradeMessage.Builder bd = DeviceAppUpgradeMessage.newBuilder();
			bd.setVersion(info.getVersion());
			bd.setVerNumber(info.getVernumber());
			bd.setPackageName(info.getPackagename());
			bd.setPackageUrl(info.getPackageurl());
			DeviceAppUpgradeMessage req = bd.build();
			  
			List<WxAccountInfo>  list = wxAccountDao.findAccountWechatInfoByCid(info.getCid());
			if(null != list && list.size()>0){
				for(int i=0;i<list.size();i++){
					WxAccountInfo wxinfo = list.get(i);
					if(null != wxinfo && !StringUtils.isEmpty(wxinfo.getWechatid())){
						UpgradeDeviceAppNoticeMessage.Builder ubd =  UpgradeDeviceAppNoticeMessage.newBuilder();
						ubd.setWeChatId(wxinfo.getWechatid());
						ubd.setIMEI(wxinfo.getDeviceid());
						ubd.addAppInfos(req);
						UpgradeDeviceAppNoticeMessage updateMessage = ubd.build();
						
						ChannelHandlerContext chx = NettyConnectionUtil.getClientChannelHandlerContextByUserId(wxinfo.getWechatid());
						if (null != chx) {
							// 发给手机端
							MessageUtil.sendMsg(chx, EnumMsgType.UpgradeDeviceAppNotice, null, null, updateMessage);
						}
					}
					
				}
			}
			
			
		}
		
	}
	 
	
}
