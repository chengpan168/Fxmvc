package com.eden.fxmvc.context.event;

import java.util.EventObject;

public class ContextEvent extends EventObject{
	private static final long serialVersionUID = 7479661475124127013L;
	
	public ContextEvent(Object source) {
		super(source);
	}
}
