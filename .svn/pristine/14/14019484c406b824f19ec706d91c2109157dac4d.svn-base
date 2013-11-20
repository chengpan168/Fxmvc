package com.eden.fxmvc.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Map<String , Object> data = null ;
	private List<Object> errList ;
	
	public Model() {
		data = new HashMap<String, Object>() ;
		errList = new ArrayList<Object>() ;
	}
	
	public Model(String key , Object value){
		data = new HashMap<String, Object>() ; 
		data.put(key, value) ;
	}
	
	public void setAttribute(String key , Object value) {
		data.put(key , value) ;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAttrbute(String key) {
		return (T)data.get(key) ;
	}
	
	public String toString(){
		return super.toString() + this.data.toString() ;
	}

	public void addErr(String err) {
		errList.add(err) ;
	}
	
	public List<Object> getErr(){
		return errList ;
	}

	public boolean hasErr() {
		if(errList.size() > 0) 
			return true ;
		return false;
	}
}
