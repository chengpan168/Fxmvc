package com.eden.fxmvc.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class FormatUtils {
	public static String formatDate(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd") ;
	}
	public static String formatDate(long timeMillis) {
		return DateFormatUtils.format(timeMillis, "yyyy-MM-dd") ;
	}
}
