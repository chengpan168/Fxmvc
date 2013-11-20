package com.eden.fxmvc.mvc.resolver;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.eden.fxmvc.context.AppContext;
import com.eden.fxmvc.mvc.annotation.ViewMapper.Target;
import com.eden.fxmvc.pane.BasePane;
import com.eden.fxmvc.ui.DisplayView;
import com.eden.fxmvc.ui.ModelAndView;

@Component("fxViewResolver")
public class FxViewResolver implements ViewResolver {
	@Resource(name="centerView")
	private DisplayView displayView ;
	
	@Override
	public BasePane buildView(ModelAndView mv) {
		
		BasePane pane = AppContext.getBean(mv.getViewName()) ;
		pane.setModelAndView(mv) ;
		if(mv.getViewTarget() == Target.current )
			displayView.setContent(pane) ;
		else if(mv.getViewTarget() == Target.blank){
			pane.show() ;
		}
		return pane;
	}

	
	public DisplayView getDisplayView() {
		return displayView;
	}

	public void setDisplayView(DisplayView displayView) {
		this.displayView = displayView;
	}

}
