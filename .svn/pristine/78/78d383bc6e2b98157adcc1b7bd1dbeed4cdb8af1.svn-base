package com.eden.fxmvc.ui;

import java.lang.reflect.Method;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import com.eden.fxmvc.constant.FXConstant;
import com.eden.fxmvc.context.AppContext;
import com.eden.fxmvc.dao.support.Page;
import com.eden.fxmvc.mvc.FxService;
import com.eden.fxmvc.mvc.action.ActionContext;
import com.eden.fxmvc.mvc.action.ActionMessage;
import com.eden.fxmvc.mvc.action.BaseAction;
import com.eden.fxmvc.mvc.annotation.ViewMapper;
import com.eden.fxmvc.pane.BaseAddPane;
import com.eden.fxmvc.pane.BaseListPane;
import com.eden.fxmvc.pane.BasePane;
import com.eden.fxmvc.util.LogUtils;

public class Location {
	public static void go(ActionContext context) {
		try {
			FxService fxService = AppContext.getBean("fxService") ;
			fxService.doService(context) ;
		} catch (Exception e) {
			LogUtils.log4Error("location forward  error ", e) ;
		}
	}
	
	public static void go(String actionName) {
		try{
			BaseAction action = AppContext.getBean(actionName) ;
			try {
				Method executeMethod = action.getClass().getMethod(FXConstant.ACTION_EXECUTE, ActionMessage.class) ;
				ViewMapper mapper = executeMethod.getAnnotation(ViewMapper.class) ;
				if(mapper != null) {
					BasePane pane = AppContext.getBean(mapper.value()) ;
					if(pane instanceof BaseAddPane) {
						go(new ActionContext(actionName, null) ) ;
					} else if(pane instanceof BaseListPane) {
						Page page = null ;
						if(pane != null) 
							page = pane.getQueryPage() ;
						ActionMessage message = new ActionMessage() ;
						message.addAttribute(FXConstant.PAGE , page ) ;
						go(new ActionContext(actionName, message) ) ;
					}
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace() ;
		}
	}

	public static void go(String actionName , Page p) {
		BaseAction action = AppContext.getBean(actionName) ;
		try {
			Method executeMethod = action.getClass().getMethod(FXConstant.ACTION_EXECUTE, ActionMessage.class) ;
			ViewMapper mapper = executeMethod.getAnnotation(ViewMapper.class) ;
			if(mapper != null) {
				ActionMessage message = new ActionMessage() ;
				message.addAttribute(FXConstant.PAGE , p ) ;
				go(new ActionContext(actionName, message) ) ;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 展示添加面板
	 * @param pane
	 */
	public static void show(BasePane pane){
		
		Stage stage = instanceOne() ;
		((BorderPane)stage.getScene().getRoot()).setCenter(pane) ;
		stage.show() ;
		
	}
	
	private static Stage stageSingle = null ;
	public static Stage instanceOne(){
		if(stageSingle != null) return stageSingle ;
		
		stageSingle = new Stage(StageStyle.UTILITY) ;
		Scene stageSingleScene = new Scene(new BorderPane() , 500 , 600 ) ;
		stageSingleScene.getStylesheets().add("css/hairangel.css");
		stageSingle.initModality(Modality.APPLICATION_MODAL) ;
		stageSingle.setScene(stageSingleScene) ;
		
		stageSingle.initOwner((Window) AppContext.getAttribute(FXConstant.WINDOW)) ;
		
		return stageSingle ;
	}

}
