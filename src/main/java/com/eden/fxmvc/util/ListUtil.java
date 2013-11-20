package com.eden.fxmvc.util;

import java.util.Iterator;
import java.util.List;

public class ListUtil {
	public static String join(List<? extends Object> list , String str) {
		if(list == null || list.size() == 0) return "" ;
		
		StringBuilder sb = new StringBuilder();
		Iterator<? extends Object> iter = list.iterator() ;
		while(iter.hasNext()){
			sb.append(iter.next()) ;
			if(iter.hasNext()) {
				sb.append(str) ;
			}
		}
		return sb.toString() ;
	}

	public static boolean isEmpty(List<? extends Object> list) {
		if(list == null ) return true ;
		return list.isEmpty() ;
	}

	public static boolean isNotEmpty(List<? extends Object> list) {
		return !isEmpty(list) ;
	}
}
