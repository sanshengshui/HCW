package com.haro.netty.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;  
	  
    public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }  
  
    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {  
        SpringUtil.applicationContext = applicationContext;  
    }  
}
