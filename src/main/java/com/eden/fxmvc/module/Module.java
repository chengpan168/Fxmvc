package com.eden.fxmvc.module;

import com.eden.fxmvc.pane.BasePane;

public class Module {
	private String location ;
	private String title ;
	private Module parent ;
	private boolean isLeaf ;
	private BasePane view ;
	private String action ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public Module getParent() {
		return parent;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	}
	public BasePane getView() {
		return view;
	}
	public void setView(BasePane view) {
		this.view = view;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
