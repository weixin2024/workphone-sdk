package com.jubotech.business.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.service.AccountService;

@Controller
public class AdminController {

	@Autowired
	private AccountService service;
  
	/**
	 * 到密码修改页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/pwd", method = RequestMethod.GET)
	public ModelAndView pwd() {
		return new ModelAndView("/admin/pwd");
	}

	/**
	 * 到密码修改页面
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/pwdedit", method = RequestMethod.POST)
	public String pwdedit(@RequestParam(value = "newpwd") String newpwd, @RequestParam(value = "oldpwd") String oldpwd,
			HttpServletRequest request) {
		AccountInfo ui = (AccountInfo) request.getSession(false).getAttribute("admin");
		return service.pwdedit(newpwd, oldpwd, ui);
	}
}
