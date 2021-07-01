package com.jubotech.business.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.DepartmentInfo;
import com.jubotech.business.web.domain.DeviceStateInfo;
import com.jubotech.business.web.domain.req.DeviceStateInfoVo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.DepartmentService;
import com.jubotech.business.web.service.DeviceStateService;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.util.SessionUtil;

@Controller
@RequestMapping("/user/device")
public class DeviceController {
	
	@Autowired
	private DeviceStateService service;
	
	@Autowired
	private DepartmentService departmentservice;
	
	@Autowired
	private AccountService accountService;
    
    /**
     * 进入列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(HttpServletRequest request ,DeviceStateInfoVo vo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	vo.setCid(info.getCid());
    	List<AccountInfo> userList = accountService.getAllAccountInfoByCid(info.getCid());
    	List<DepartmentInfo>  departmentList= departmentservice.getAllDepartmentInfoByCid(info.getCid());
    	PageBean<DeviceStateInfo> pageBean = service.queryDeviceStateInfo(vo);
    	map.put("pageBean", pageBean);
    	map.put("info", vo);
    	map.put("userList", userList);
    	map.put("departmentList",departmentList);
    	return new ModelAndView("/user/devicestatelist",map);
    }
    
    /**
     * 到添加页面
     * @return
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public ModelAndView toadd(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<AccountInfo> userList = accountService.getAllAccountInfoByCid(info.getCid());
    	map.put("entity", new DeviceStateInfo());
    	map.put("userList", userList);
    	return new ModelAndView("/user/deviceadd",map);
    }
    
    /**
     * 到修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/toedit/{id}",method = RequestMethod.GET)
    public ModelAndView toedit(@PathVariable(value="id") Integer id,HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo accinfo = SessionUtil.getAccountInfo(request);
    	List<AccountInfo> userList = accountService.getAllAccountInfoByCid(accinfo.getCid());
    	DeviceStateInfo info = service.findDeviceStateInfoByid(id);
    	map.put("entity", info);
    	map.put("userList", userList);
    	return new ModelAndView("/user/deviceadd",map);
    }
    
    /**
     * 信息修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(DeviceStateInfo info,HttpServletRequest request){
    	return service.update(info);
    }
    
    /**
     * 信息添加
     * @param info
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(DeviceStateInfo info,HttpServletRequest request){
    	AccountInfo acc =  SessionUtil.getAccountInfo(request);
    	Integer cid = acc.getCid();
    	info.setCid(cid);
    	
    	return service.insert(info);
    }
    
    
    /**
     * 绑定账号
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/binding" ,method = RequestMethod.POST)
    public boolean binding(Integer accountid,String ids,HttpServletRequest request){
    	return service.binding(accountid,ids);
    }
    
    
    /**
     * 信息删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable(value="id") Integer id,HttpServletRequest request){
    	service.delete(id);
    	return list(request,new DeviceStateInfoVo());
    }
    
}
