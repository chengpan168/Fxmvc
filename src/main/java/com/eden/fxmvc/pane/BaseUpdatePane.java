package com.eden.fxmvc.pane;


import java.util.Arrays;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import com.eden.fxmvc.component.CgLabel;
import com.eden.fxmvc.constant.FXConstant;
import com.eden.fxmvc.context.AppContext;

public class BaseUpdatePane extends BasePane {
	private VBox vBox = null ;
	private VBox content = null ;
	private ScrollPane scrollPane = null ;
	protected Stage stageSingle ;
	public BaseUpdatePane(){
		stageSingle = new Stage(StageStyle.UTILITY) ;
		Scene stageSingleScene = new Scene(this , 500 , 600 ) ;
		stageSingleScene.getStylesheets().addAll(Arrays.asList(FXConstant.STYLE_SHEETS)) ;
		stageSingle.initModality(Modality.APPLICATION_MODAL) ;
		stageSingle.setScene(stageSingleScene) ;
		stageSingle.setMinHeight(500) ;
		stageSingle.setMinWidth(400) ;
		stageSingle.initOwner((Window) AppContext.getAttribute(FXConstant.WINDOW)) ;
		stageSingle.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent paramT) {
				clear() ;
			}
		}) ;
		
	}
	
	public BaseUpdatePane(String title) {
		this() ;
		getStylesheets().addAll(Arrays.asList(FXConstant.STYLE_SHEETS)) ;
		
		vBox = new VBox() ;
		
		HBox addTop = new HBox() ;
		addTop.prefWidthProperty().bind(this.widthProperty() ) ;
		addTop.setPrefHeight(10) ;
		addTop.getStyleClass().add("baseAddPaneTop") ;
		vBox.getChildren().add(addTop) ;
		VBox.setMargin(addTop, new Insets(2, 0, 0, 0)) ;
		
		//标题位置，字体等。。。
		HBox titleBox = new HBox() ;
		
		title = title + "(*号不能为空)" ;
		Label titleText = new CgLabel(title) ;
		titleText.setTextAlignment(TextAlignment.LEFT) ;
		titleText.setAlignment(Pos.BOTTOM_LEFT) ;
		
		HBox.setMargin(titleText, new Insets(5, 0, 0, 20) ) ;
		titleBox.getChildren().add(titleText) ;
//		titleBox.prefWidthProperty().bind(this.widthProperty().subtract(20) ) ;
		titleBox.setPrefHeight(23) ;
		
		titleBox.getStyleClass().add("baseAddPaneTitle") ;
		
		vBox.getChildren().add(titleBox) ;
		
		VBox.setMargin(titleBox , new Insets(5 , 5 , 0 , 5)) ;
		
		scrollPane = new ScrollPane() ;
		scrollPane.prefHeightProperty().bind(this.heightProperty().subtract(45) ) ;
		scrollPane.getStyleClass().add("addScrollPane") ;
		
		VBox.setMargin(scrollPane , new Insets(0 , 5 , 0, 5)) ;
		vBox.getChildren().add(scrollPane) ;
		
		content = new VBox() ;
		scrollPane.setContent(content) ;

		this.getChildren().add(vBox) ;
		
	}
	
	
	
	public void setContent(Pane pane ){
		
		VBox.setMargin(pane, new Insets(15 , 0, 0, 30)) ;
		content.getChildren().add(pane) ;
		
	}
	
	public void show() {
		stageSingle.show() ;
	}
	public void close(){
		stageSingle.close() ;
	}
}
