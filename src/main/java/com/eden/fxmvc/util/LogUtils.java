package com.eden.fxmvc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtils {
	private static Log errorLogger = LogFactory.getLog("ERR");

	public static void log4Error(String info) {
		errorLogger.error(info);
	}
	public static void log4Error(String info, Throwable t) {
		errorLogger.error(info, t);
	}
	public static void log4Error(Throwable t) {
		errorLogger.error(t.getMessage(), t);
	}

}
