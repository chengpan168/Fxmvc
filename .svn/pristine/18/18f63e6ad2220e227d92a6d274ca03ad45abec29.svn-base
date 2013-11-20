package com.eden.fxmvc.bean;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import com.eden.fxmvc.util.TypeConvertUtil;

public class DefaultBeanWraper extends BeanWrapperImpl implements SpringBeanWraper{
	
	public DefaultBeanWraper(Object instance) {
		super(instance) ;
	}

	/**
	 * 把所有的列转换为字符串存储
	 * @param propertyName
	 * @param value
	 */
	@Override
	public void setStrValue(String propertyName, Object value) {
		String strValue = "" ;
		if(value != null) {
			if(value instanceof String) {
				strValue = (String) value ;
			} else if(value instanceof Number ) {
				strValue = String.valueOf(((Number)value).toString()) ;
			} else if (value instanceof Date) {
				strValue = DateFormatUtils.format(((Date) value).getTime(), "yyyy-MM-dd HH:mm:ss") ;
			} else {
				strValue = value.toString() ;
			}
		}
		setPropertyValue(propertyName, strValue);
	}
	
	@Override
	public void setObjectValue(String propertyName, Object value) {
		setPropertyValue(propertyName, value );
	}
	
	@Override
	public String getPropertyStrValue(String propertyName) {
		return TypeConvertUtil.toStr(getPropertyValue(propertyName)) ;
	}
	
	@Override
	public void setPropertyValue(String propertyName, Object value)
			throws BeansException {
		super.setPropertyValue(propertyName, value);
	}
}

	
