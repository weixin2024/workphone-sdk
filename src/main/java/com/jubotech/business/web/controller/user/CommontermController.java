package com.jubotech.business.web.controller.user;

import java.util.HashMap;
import java.util.List;
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
import com.jubotech.business.web.domain.CommontermInfo;
import com.jubotech.business.web.domain.CommontermType;
import com.jubotech.business.web.domain.DepartmentInfo;
import com.jubotech.business.web.domain.req.CommontermVo;
import com.jubotech.business.web.service.CommontermService;
import com.jubotech.business.web.service.CommontermTypeService;
import com.jubotech.business.web.service.DepartmentService;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.util.PropertyUtils;
import com.jubotech.framework.util.SessionUtil;

@Controller
@RequestMapping("/user/commonterm")
public class CommontermController {
	@Autowired
	private Environment env;
	
	@Autowired
	private CommontermService service;
	
	@Autowired
	private DepartmentService departmentservice;
	
	@Autowired
	private CommontermTypeService commontermTypeService;
    
    /**
     * 进入列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(HttpServletRequest request ,CommontermVo vo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<DepartmentInfo>  departmentList= departmentservice.getAllDepartmentInfoByCid(info.getCid());
    	List<CommontermType> commontermTypeList =  commontermTypeService.getAllCommontermTypeByCid(info.getCid());
    	vo.setCid(info.getCid());
    	PageBean<CommontermInfo> pageBean = service.queryCommontermInfo(vo);
    	map.put("pageBean", pageBean);
    	map.put("info", vo);
    	map.put("departmentList", departmentList);
    	map.put("commontermTypeList",commontermTypeList);
    	return new ModelAndView("/user/commontermlist",map);
    }
    

    
    /**
     * 到添加页面
     * @return
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public ModelAndView toadd(HttpServletRequest request){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<DepartmentInfo> departmentList = departmentservice.getAllDepartmentInfoByCid(info.getCid());
    	List<CommontermType> commontermTypeList =  commontermTypeService.getAllCommontermTypeByCid(info.getCid());
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("entity", new CommontermInfo());
    	map.put("departmentList",departmentList);
    	map.put("commontermTypeList",commontermTypeList);
    	map.put("uploadUrl",PropertyUtils.getUploadUrl(env));
    	return new ModelAndView("/user/commontermadd",map);
    }
    
    /**
     * 到修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/toedit/{id}",method = RequestMethod.GET)
    public ModelAndView toedit(HttpServletRequest request,@PathVariable(value="id") Integer id){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<DepartmentInfo> departmentList = departmentservice.getAllDepartmentInfoByCid(info.getCid());
    	List<CommontermType> commontermTypeList =  commontermTypeService.getAllCommontermTypeByCid(info.getCid());
    	Map<String, Object> map = new HashMap<String, Object>();
    	CommontermInfo user = service.getCommontermInfoByid(id);
    	map.put("entity", user);
    	map.put("departmentList",departmentList);
    	map.put("commontermTypeList",commontermTypeList);
    	map.put("uploadUrl",PropertyUtils.getUploadUrl(env));
    	return new ModelAndView("/user/commontermadd",map);
    }
   
    /**
     * 信息修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(CommontermInfo user,HttpServletRequest request){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	user.setCid(info.getCid());
    	return service.update(user);
    }
    
    /**
     * 信息添加
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(CommontermInfo user,HttpServletRequest request){
    	AccountInfo info =  SessionUtil.getAccountInfo(request);
    	user.setCid(info.getCid());
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
    	return list(request,new CommontermVo());
    }
  
}
