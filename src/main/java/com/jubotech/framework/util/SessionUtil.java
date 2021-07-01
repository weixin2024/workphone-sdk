package com.jubotech.framework.util;

import javax.servlet.http.HttpServletRequest;

import com.jubotech.business.web.domain.AccountInfo;

public class SessionUtil {
    
    public static AccountInfo getAccountInfo(HttpServletRequest request){
    	return (AccountInfo) request.getSession(false).getAttribute("admin");
    }
     
}
