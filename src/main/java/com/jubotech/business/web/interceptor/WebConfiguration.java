package com.jubotech.business.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("进入拦截器。。。。");
//		InterceptorRegistration ir =  registry.addInterceptor(new ExceptionInterceptor());
//		ir.addPathPatterns("/**");
//		ir.excludePathPatterns("/","/cms/**");
		
		registry.addInterceptor(new ExceptionInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/user/login","/fileUpload","/web");
	    super.addInterceptors(registry);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	 registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    	 registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    	 registry.addResourceHandler("/juliao/**").addResourceLocations("file:/home/data/juliao/");
         super.addResourceHandlers(registry);
    }
}
