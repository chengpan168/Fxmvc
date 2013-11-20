package com.eden.fxmvc.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 非线程安全的
 * @author Eden
 *
 */
public class NumberFormatUtil {
	//非线程安全
	private static NumberFormat nf = new DecimalFormat("") ;
	
	public static String formatDouble(double num){
		return nf.format(num) ;
	}
	
	public static double formatDouble(double num , int scale){
		if (scale < 1) {
			return Math.round(num) ;
		}
		return Math.round(Math.pow(10 , scale) * num)/Math.pow(10 , scale) ;
	}
}
