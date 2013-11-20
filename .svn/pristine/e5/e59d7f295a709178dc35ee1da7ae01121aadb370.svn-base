package com.eden.fxmvc.mybatis.dialect;


import org.apache.commons.lang.StringUtils;

import com.eden.fxmvc.mybatis.dialect.Dialect.Dialect_type;

public class DialectFactory {
	private static Dialect dialect ;
	
	/**
	 * 不是线程安全的
	 * @param dialectName
	 * @return
	 */
	public static Dialect getDialect(String dialectName){
		if(StringUtils.equalsIgnoreCase(dialectName, Dialect_type.derby.toString()) ){
			if(dialect == null )
				dialect = new DerbyDialect() ;
		}
		return dialect ;
	}
	
	public static void main(String[] args) {
		System.out.println(Dialect_type.derby.toString().equalsIgnoreCase("derby")) ;
	}
}
