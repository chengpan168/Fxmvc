package com.eden.fxmvc.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * where to forward after execute an action 
 * @author eden
 * 
 * @param target 默认“” , 如果填写就把当前value指向的BasePane写到其中
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewMapper {
	public enum Target {
		current , blank
	}
	String value() default "" ;
	Target target() default Target.current ;
}
