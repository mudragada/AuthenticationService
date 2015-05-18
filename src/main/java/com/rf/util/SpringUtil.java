package com.rf.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUtil {
	//Singleton for context
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	public static ApplicationContext getContext() {
		return context;
	}

}
