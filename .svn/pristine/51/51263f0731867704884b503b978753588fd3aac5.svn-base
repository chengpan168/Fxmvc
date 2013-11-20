package com.eden.fxmvc.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * column's name chinese english 
 * @author eden
 * 
 * @param target 
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewColumn {
	String nameCn() default "" ;
	String nameEn() default "" ;
	String dbName() default "" ;
	String table() default "" ;
}
