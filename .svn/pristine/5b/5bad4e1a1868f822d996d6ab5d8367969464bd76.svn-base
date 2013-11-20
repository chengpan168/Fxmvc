package com.eden.fxmvc.mvc.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.eden.fxmvc.context.AppContext;
import com.eden.fxmvc.exception.ActionException;
import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.mvc.action.ActionMessage;
import com.eden.fxmvc.mvc.action.BaseAction;
import com.eden.fxmvc.mvc.annotation.InterceptorOrder;
import com.eden.fxmvc.mvc.annotation.ViewMapper;
import com.eden.fxmvc.ui.ModelAndView;

@InterceptorOrder(order=-1)
@Component
public class InterceptorChain implements Interceptor {
	private static final Log log = LogFactory.getLog(InterceptorChain.class) ;
	
	@Resource
	private List<Interceptor> interceptors ;
	
	private List<Interceptor> sortedInterceptors ;
	private int index = 0 ;
	private int size = 0 ;
	
	@Override
	public ModelAndView intercept(ActionContext context , InterceptorChain chain ){
		ModelAndView mv = null ;
		while(hasNext()){
			Interceptor interceptor = next() ;
			if(interceptor != null ) {
				mv = interceptor.intercept(context , chain ) ;
				return mv ;
			}
			
		}
		mv = executeAction(context) ;
		return mv ;
	}

	public boolean hasNext(){
		if(sortedInterceptors == null){
			sortedInterceptors = sortInterceptor(interceptors) ;
			size = sortedInterceptors.size() ;
		}
		return index < size ;
	}
	
	public Interceptor next(){
		return sortedInterceptors.get(index++) ;
	}
	
	public void reset(){
		index = 0 ;
	}
	
	/**
	 * execute action 
	 * @param context
	 * @return
	 */
	public ModelAndView executeAction(ActionContext context) {
		try {
			BaseAction action = AppContext.getBean(context.getPath()) ;
			if(action != null && action instanceof BaseAction ) {
				ModelAndView mv = action.execute(context.getActionMessage()) ;
				ViewMapper vm = action.getClass().getDeclaredMethod("execute", ActionMessage.class).getAnnotation(ViewMapper.class) ; 
				if(mv== null) {
					log.warn("execute action :" + action + "return null ") ;
					mv = new ModelAndView() ;
				}
				if(vm!= null ) {
					String pane = vm.value() ;
					mv.setViewName(pane) ;
					mv.setViewTarget(vm.target()) ;
				}
				return mv ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActionException(e) ;
		}
		return null;
	}
	
	/**
	 * sort the interceptors with the annotation of InterceptorOrder
	 * @param interceptors
	 * @return
	 */
	public List<Interceptor> sortInterceptor(List<Interceptor> interceptors){
		sortedInterceptors = new ArrayList<Interceptor>() ;
		for(int i = 0 ; i < 10 ; i++){
			sortedInterceptors.add(i , null) ;
		}
		for(Interceptor interceptor : interceptors){
			InterceptorOrder order = interceptor.getClass().getAnnotation(InterceptorOrder.class) ;
			if(order != null){
				if(order.order() >= 0){
					sortedInterceptors.set(order.order() , interceptor) ;
				}
			}
		}
		return sortedInterceptors ;
	}
	
	public List<Interceptor> getInterceptors() {
		return interceptors;
	}

	public void setInterceptors(List<Interceptor> interceptors) {
		this.interceptors = interceptors;
	}

}
