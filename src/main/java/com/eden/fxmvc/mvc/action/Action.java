package com.eden.fxmvc.mvc.action;

import com.eden.fxmvc.ui.ModelAndView;

public interface Action {
	public ModelAndView execute(ActionMessage actionMessage ) ;
}
