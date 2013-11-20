package com.eden.fxmvc.validation;

import java.util.HashMap;
import java.util.Map;

import com.eden.fxmvc.util.TypeConvertUtil;

public class Errors {
	private Map<String , Object> errorMap ;
	private static final String STATUS = "_status" ;
	
	public Errors(){
		errorMap = new HashMap<String, Object>() ;
	}
	
	public void put(String key , Object value) {
		errorMap.put(key, value) ;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		Object value = errorMap.get(key) ;
		if(value != null) {
			return (T) value ;
		}
		return null;
	}
	
	public void setStatus(String status) {
		errorMap.put(STATUS , status) ;
	}
	
	public String getStatus() {
		return TypeConvertUtil.toStr(errorMap.get(STATUS )) ;
	}
	
	public String toString(){
		return super.toString() + "[" + errorMap.toString() + "]" ;
	}
}
