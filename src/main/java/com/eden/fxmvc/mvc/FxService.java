package com.eden.fxmvc.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.mvc.action.ActionInvocation;
import com.eden.fxmvc.mvc.resolver.ViewResolver;
import com.eden.fxmvc.pane.BasePane;
import com.eden.fxmvc.ui.ModelAndView;

@Service
public class FxService {
	@Resource(name="fxViewResolver")
	private ViewResolver viewResolver ;
	@Resource
	private ActionInvocation actionInvocation ;
	
	public void doService(ActionContext context){
		ModelAndView mv = actionInvocation.invoke(context) ;
		BasePane pane = viewResolver.buildView(mv) ;
		pane.update(mv) ;
	}

	
	public ViewResolver getViewResolver() {
		return viewResolver;
	}

	public void setViewResolver(ViewResolver viewResolver) {
		this.viewResolver = viewResolver;
	}

	public ActionInvocation getActionInvocation() {
		return actionInvocation;
	}

	public void setActionInvocation(ActionInvocation actionInvocation) {
		this.actionInvocation = actionInvocation;
	}
}
