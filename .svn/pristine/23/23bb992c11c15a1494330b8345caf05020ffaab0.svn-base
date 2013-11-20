package com.eden.fxmvc.mvc.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.mvc.annotation.InterceptorOrder;
import com.eden.fxmvc.ui.ModelAndView;

@InterceptorOrder(order=6)
@Component
public class ParameterInterceptor implements Interceptor {
	private static final Log log = LogFactory.getLog(ParameterInterceptor.class) ;
	
	@Override
	public ModelAndView intercept(ActionContext context , InterceptorChain chain ) {
		log.debug("parameter before execute action ") ;
		ModelAndView mv = chain.intercept(context, chain) ;
		log.debug("parameter after execute action ") ;
		return mv ;
	}

}
