package com.eden.fxmvc.context.listener;

import java.util.EventListener;

import com.eden.fxmvc.context.event.ContextEvent;

public interface ContextListener extends EventListener{
	/**
	 * 程序初始化时
	 * @param event
	 */
	public void contextInitialized(ContextEvent event) ;
	
	/**
	 * 程序结束时
	 * @param event
	 */
	public void contextDestroyed(ContextEvent event ) ;
}
