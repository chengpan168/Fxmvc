package com.eden.fxmvc.context;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.Configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware  , DisposableBean{
	private final static Log log = LogFactory.getLog(AppContext.class) ;
	private static ApplicationContext applicationContext ;
	private static Configuration configuration ;
	//保存当前运行中变量
	private static Map<String, Object> dataMap  ;

	public static boolean init(){
		try{
			log.info("initialize spring context") ;
			new ClassPathXmlApplicationContext(new String[]{"classpath*:applicationContext.xml" , "classpath*:fxmvc.xml"}) ;
			dataMap = new HashMap<String, Object>() ;
			return true ;
		}catch(Exception e) {
			log.error("application start error" , e) ;
			return false ;
		}
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static void setConfiguration(Configuration configuration) {
		AppContext.configuration = configuration;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(String key) {
		return (T) dataMap.get(key) ;
	}
	
	public static void setAttribute(String key , Object value) {
		dataMap.put(key, value) ;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		try {
			return (T) applicationContext.getBean(name) ;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext newApplicationContext)
			throws BeansException {
		applicationContext = newApplicationContext ;
	}

	@Override
	public void destroy() throws Exception {
		applicationContext = null ;
	}
}
