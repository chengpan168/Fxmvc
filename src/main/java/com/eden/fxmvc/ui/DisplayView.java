package com.eden.fxmvc.ui;

import com.eden.fxmvc.pane.BasePane;

import javafx.scene.layout.BorderPane;

public class DisplayView extends BorderPane{
	public void setContent(BasePane pane){
		this.setCenter(pane) ;
		pane.prefWidthProperty().bind(this.widthProperty()); 
		pane.prefHeightProperty().bind(this.heightProperty()); 
	}
}
