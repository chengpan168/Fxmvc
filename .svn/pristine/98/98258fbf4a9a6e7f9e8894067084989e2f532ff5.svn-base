package com.eden.fxmvc.mvc.action;

import java.util.HashMap;

public class ActionMessage extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;
	
	
	public ActionMessage(){
		super() ;
	}
	
	
	public ActionMessage(String key, Object value) {
		put(key , value) ;
	}

	public void addAttribute(String key , Object value){
		put(key , value) ;
	} 
	
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String key) {
		return  (T) get(key) ;
	}

}
