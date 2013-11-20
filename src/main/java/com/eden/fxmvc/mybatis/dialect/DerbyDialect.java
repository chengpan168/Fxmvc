package com.eden.fxmvc.mybatis.dialect;



public class DerbyDialect implements Dialect {

	@Override
	public String getLimitSql(String sql, int firstResult, int maxResult) {
		sql = sql  +  " OFFSET " + firstResult + " ROWS FETCH NEXT "  
				+  maxResult + " ROWS ONLY " ;
		return sql;
	}

}
