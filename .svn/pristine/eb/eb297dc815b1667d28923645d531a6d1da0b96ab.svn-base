package com.eden.fxmvc.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.RowBounds;

import com.eden.fxmvc.mybatis.dialect.Dialect;
import com.eden.fxmvc.mybatis.dialect.DialectFactory;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private static final Log log = LogFactory.getLog(PageInterceptor.class);

	private String dialectType;
	
	private Dialect dialect  ;

	public PageInterceptor(){
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		if (dialect == null) {
			return invocation.proceed();
		}

		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject
				.forObject(statementHandler);
		RowBounds rowBounds = (RowBounds) metaStatementHandler
				.getValue("delegate.rowBounds");
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}

		String originalSql = (String) metaStatementHandler
				.getValue("delegate.boundSql.sql");

		metaStatementHandler.setValue("delegate.boundSql.sql", dialect
				.getLimitSql(originalSql, rowBounds.getOffset(),
						rowBounds.getLimit()));

		metaStatementHandler.setValue("delegate.rowBounds.offset",
				RowBounds.NO_ROW_OFFSET);

		metaStatementHandler.setValue("delegate.rowBounds.limit",
				RowBounds.NO_ROW_LIMIT);

		if (log.isDebugEnabled()) {
			log.debug("generate page SQL : " + boundSql.getSql());
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.dialectType = properties.getProperty("dialectType") ;
		dialect  = DialectFactory.getDialect(dialectType) ;
	}
}
