package com.eden.fxmvc.mvc.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.mvc.annotation.InterceptorOrder;
import com.eden.fxmvc.ui.ModelAndView;

@InterceptorOrder(order=5)
@Component
public class PermissionInterceptor implements Interceptor {
	private static final Log log = LogFactory.getLog(PermissionInterceptor.class) ;
	
	@Override
	public ModelAndView intercept(ActionContext context , InterceptorChain chain ) {
		log.debug("permission before execute action ") ;
		ModelAndView mv = chain.intercept(context, chain) ;
		log.debug("permission after execute action ") ;
		return mv;
	}

}
