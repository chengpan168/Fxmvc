package com.eden.fxmvc.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * the order of interceptor execute 
 * it is not execute if order is -1
 * @author eden
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InterceptorOrder {
	int order() default 0 ;
}
