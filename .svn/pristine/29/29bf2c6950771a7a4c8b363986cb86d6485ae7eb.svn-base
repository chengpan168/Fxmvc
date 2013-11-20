package com.eden.fxmvc.util;

import org.apache.commons.lang.StringUtils;

public class ValidateUtil {
	/**
	 * 判断字符串的长度是否在指定的范围内
	 * @param str
	 * @param minLength
	 * @param maxLength
	 * @return
	 */
	public static boolean isLengthLimit(String str , int minLength  , int maxLength) {
		int lenght = getLength(str) ;
		return (lenght >= minLength && lenght <= maxLength) ;
	}
	
	public static int getLength (String str) {
		if (str == null) {
			return 0 ;
		}
		return str.length() ;
	}
	
	/**
	 * 判断字符串是否为纯数字
	 */
	public static boolean isNumber(String str) {
		if (StringUtils.isBlank(str))
			return false;
		for (int j = 0; j < str.length(); j++) {
			if (!(str.charAt(j) >= 48 && str.charAt(j) <= 57)) {
				return false;
			}
		}
		return true;
	}
}
