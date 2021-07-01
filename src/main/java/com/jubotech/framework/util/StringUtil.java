package com.jubotech.framework.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

public class StringUtil {
	/**
	 * 首字母变小写
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}
	
	  
	public static List<String> stringToList(String str){
    	List<String> list = new ArrayList<>();
    	if(!StringUtils.isEmpty(str)){
    		String [] s = str.split(",");
    		if(null != s && s.length>0){
    			for(int i=0;i<s.length;i++){
    				list.add(s[i]);
    			}
    		}else{
    			list.add(str);
    		}
    	}
    	return list;
    }
    
	public static String ListToString(List<String> list){
    	String s = "";
    	if(null != list && list.size()>0){
    		for(int i=0;i<list.size();i++){
    			s = s + list.get(i) +",";
    		}
    	}
    	if(!StringUtils.isEmpty(s) && s.endsWith(",")){
    		s = s.substring(0, s.length()-1);
    	}
    	return s;
    	
    }
    
	public static List<String> removeRepeat(List<String> list){
    	Set<String> set = new  HashSet<>(); 
        List<String> newList = new  ArrayList<String>(); 
        for (String cd:list) {
           if(set.add(cd)){
               newList.add(cd);
           }
       }
    	return newList;
    }
	
}
