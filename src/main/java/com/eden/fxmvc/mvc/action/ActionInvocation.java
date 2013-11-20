package com.eden.fxmvc.mvc.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.eden.fxmvc.context.AppContext;
import com.eden.fxmvc.mvc.annotation.ViewMapper;
import com.eden.fxmvc.mvc.interceptor.InterceptorChain;
import com.eden.fxmvc.ui.ModelAndView;
import com.eden.fxmvc.util.LogUtils;

@Component
public class ActionInvocation {
	
	@Resource
	private InterceptorChain interceptorChain ;
	
	
	public ModelAndView invoke(ActionContext context) {
		try {
			//reset the interceptors 
			interceptorChain.reset() ;
			ModelAndView mv = interceptorChain.intercept(context, interceptorChain) ;
			if(mv!= null) {
				return mv ;
			}
			return mv ;
		} catch (Exception e) {
			LogUtils.log4Error("execute action error ",  e ) ;
		}
		return null ;
	}

	public ModelAndView executeAction(ActionContext context) throws Exception{
			BaseAction action = AppContext.getBean(context.getPath()) ;
			if(action != null && action instanceof BaseAction ) {
				ModelAndView mv = action.execute(context.getActionMessage()) ;
				ViewMapper vm = action.getClass().getDeclaredMethod("execute", ActionMessage.class).getAnnotation(ViewMapper.class) ; 
				if(mv != null && vm!= null ) {
					String pane = vm.value() ;
					mv.setViewName(pane) ;
					mv.setViewTarget(vm.target()) ;
				}
				return mv ;
			}
			return null;
	}
	
}
