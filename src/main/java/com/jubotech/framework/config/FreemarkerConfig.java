package com.jubotech.framework.config;
 
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class FreemarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        // 取消默认数字格式化
        configuration.setNumberFormat("#");
    }

}
