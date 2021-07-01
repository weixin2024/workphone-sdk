package com.jubotech.business.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.VersionControl;
import com.jubotech.business.web.domain.req.VersionControlVo;
import com.jubotech.business.web.service.VersionControlService;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.util.PropertyUtils;
import com.jubotech.framework.util.SessionUtil;

@Controller
@RequestMapping("/user/version")
public class VersionController {
	
	@Autowired
	private Environment env;
	@Autowired
	private VersionControlService service;
	 
    /**
     * 进入列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(HttpServletRequest request ,VersionControlVo vo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	vo.setCid(info.getCid());
    	PageBean<VersionControl> pageBean = service.queryVersionControl(vo);
    	map.put("pageBean", pageBean);
    	map.put("info", vo);
    	return new ModelAndView("/user/versionlist",map);
    }
     
    
    /**
     * 到添加页面
     * @return
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public ModelAndView toadd(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("entity", new VersionControl());
    	map.put("uploadUrl",PropertyUtils.getUploadUrl(env));
    	return new ModelAndView("/user/versionadd",map);
    }
    
    /**
     * 到修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/toedit/{id}",method = RequestMethod.GET)
    public ModelAndView toedit(HttpServletRequest request,@PathVariable(value="id") Integer id){
    	Map<String, Object> map = new HashMap<String, Object>();
    	VersionControl user = service.queryVersionControlById(id);
    	map.put("entity", user);
    	map.put("uploadUrl",PropertyUtils.getUploadUrl(env));
    	return new ModelAndView("/user/versionadd",map);
    }
   
    /**
     * 信息修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(VersionControl user,HttpServletRequest request){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	user.setCid(info.getCid());
    	user.setFlag(-1);
    	return service.update(user);
    }
    
    /**
     * 信息添加
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(VersionControl user,HttpServletRequest request){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	user.setCid(info.getCid());
    	user.setFlag(-1);
    	return service.insert(user);
    }
    
    /**
     * 信息删除
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    public ModelAndView userdel(@PathVariable(value="id") Integer id,HttpServletRequest request){
    	service.delete(id);
    	return list(request,new VersionControlVo());
    }
    
    
    /**
     * 推送更新
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/push/{id}" ,method = RequestMethod.GET)
    public ModelAndView push(@PathVariable(value="id") Integer id,HttpServletRequest request){
    	service.pushAppUpdate(id);
    	return list(request,new VersionControlVo());
    }
      
    
}
