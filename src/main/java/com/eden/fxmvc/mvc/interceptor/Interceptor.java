package com.eden.fxmvc.mvc.interceptor;

import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.ui.ModelAndView;

public interface Interceptor {
	public ModelAndView intercept(ActionContext context , InterceptorChain chain ) ;
}
