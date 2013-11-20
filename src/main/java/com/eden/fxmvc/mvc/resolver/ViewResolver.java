package com.eden.fxmvc.mvc.resolver;

import com.eden.fxmvc.pane.BasePane;
import com.eden.fxmvc.ui.ModelAndView;

public interface ViewResolver {
	public BasePane buildView(ModelAndView mv ) ;
	
}
