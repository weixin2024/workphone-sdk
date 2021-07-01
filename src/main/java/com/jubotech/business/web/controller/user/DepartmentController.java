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
import com.jubotech.business.web.domain.req.DepartmentVo;
import com.jubotech.business.web.service.DepartmentService;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.util.SessionUtil;

@Controller
@RequestMapping("/user/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
    
    /**
     * 进入列表
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(HttpServletRequest request ,DepartmentVo vo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	vo.setCid(info.getCid());
    	PageBean<DepartmentInfo> pageBean = service.queryDepartmentInfo(vo);
    	map.put("pageBean", pageBean);
    	map.put("info", vo);
    	return new ModelAndView("/user/departmentlist",map);
    }
    

    
    /**
     * 到添加页面
     * @return
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public ModelAndView toadd(HttpServletRequest request){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<DepartmentInfo> departmentList = service.getAllDepartmentInfoByCid(info.getCid());
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("entity", new DepartmentInfo());
    	map.put("departmentList",departmentList);
    	return new ModelAndView("/user/departmentadd",map);
    }
    
    /**
     * 到修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/toedit/{id}",method = RequestMethod.GET)
    public ModelAndView toedit(HttpServletRequest request,@PathVariable(value="id") Integer id){
    	AccountInfo info = SessionUtil.getAccountInfo(request);
    	List<DepartmentInfo> departmentList = service.getAllDepartmentInfoByCid(info.getCid());
    	Map<String, Object> map = new HashMap<String, Object>();
    	DepartmentInfo user = service.getDepartmentInfoByid(id);
    	map.put("entity", user);
    	map.put("departmentList",departmentList);
    	return new ModelAndView("/user/departmentadd",map);
    }
   
    /**
     * 信息修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(DepartmentInfo user,HttpServletRequest request){
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
    public String add(DepartmentInfo user,HttpServletRequest request){
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
    	return list(request,new DepartmentVo());
    }
      
    
}
