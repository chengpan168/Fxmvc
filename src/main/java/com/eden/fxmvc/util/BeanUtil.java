package com.eden.fxmvc.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map.Entry;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;

import com.eden.fxmvc.bean.DefaultBeanWraper;
import com.eden.fxmvc.bean.SpringBeanWraper;
import com.eden.fxmvc.mvc.action.ActionMessage;
import com.eden.fxmvc.mvc.annotation.ViewColumn;

public class BeanUtil {
	private static final Log log = LogFactory.getLog(BeanUtil.class) ;
	
	public static void copyProperty(Object entity , ActionMessage actionMessage ){
		for(Entry<String, Object> entry : actionMessage.entrySet()){
			SpringBeanWraper bean = new DefaultBeanWraper(entity) ;
			bean.setPropertyValue(entry.getKey(), entry.getValue()) ;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T invoke(Class<?> clazz , String methodName , Object param ) {
		try{
			T instantce = (T) clazz.newInstance() ;
			Method[] methods = clazz.getMethods() ;
			for(Method method : methods ) {
				if(StringUtils.equals(method.getName() , methodName)){
					return (T) method.invoke(instantce, param) ;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace() ;
		}
		return null ;
	}
	
	public static String getPropertyNameCn(Class<? extends Object> clazz , String propertyEnName){
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields) {
			ViewColumn column = field.getAnnotation(ViewColumn.class) ;
			if(column != null ) {
				if(StringUtils.isNotBlank(column.nameEn())){
					if(StringUtils.equals(propertyEnName, column.nameEn())){
						return column.nameEn() ;
					}
				} else {
					if(StringUtils.equals(propertyEnName, field.getName())){
						return column.nameEn() ;
					}
				}
				
			}
			
		}
		return null ;
	}
	
	/**
	 * get the chinese name of a property throug the class annotation 
	 * @param clazz
	 * @param propertyCnName
	 * @return
	 */
	public static String getPropertyNameEn(Class<? extends Object> clazz , String propertyCnName){
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields) {
			ViewColumn column = field.getAnnotation(ViewColumn.class) ;
			if(column != null ) {
				if(StringUtils.equals(propertyCnName, column.nameCn())){
					if(StringUtils.isBlank(column.nameEn())) {
						return field.getName() ;
					} else {
						return column.nameEn() ;
					}
				}
			}
			
		}
		return null ;
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @return target
	 */
	public static Object copyDto2View(Object source, Object target) {
		log.info("copy property [" + source + "] to [" + target) ;
		try {
			Field[] fields = target.getClass().getDeclaredFields() ;
			SpringBeanWraper sourceWraper = new DefaultBeanWraper(source) ;
			SpringBeanWraper targetWraper = new DefaultBeanWraper(target) ;
			
			for(Field field : fields){
				try {
					String fieldName =  field.getName()  ;
					if(field.getType().getSimpleName().equalsIgnoreCase("StringProperty")){
						targetWraper.setPropertyValue( fieldName
								, new SimpleStringProperty(
										TypeConvertUtil.toStr(sourceWraper.getPropertyValue(fieldName)))) ;
					} else if(field.getType().getSimpleName().equalsIgnoreCase("BooleanProperty")){
						targetWraper.setPropertyValue( fieldName
								, new SimpleBooleanProperty(
										Boolean.valueOf(TypeConvertUtil.toStr(sourceWraper.getPropertyValue(fieldName)))
										)) ;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return target ;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return target ;
	}
}
