package com.eden.fxmvc.dao.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.eden.fxmvc.dao.DaoService;

public class DefaultDaoServiceImpl extends SqlSessionDaoSupport implements
		DaoService {
	private SqlSessionTemplate batchSqlSession ;
	
	@Override
	public int insert(String statement) {
		return getSqlSession().insert(statement);
	}

	@Override
	public <T> int insertBatch(T o) {
		return getBatchSqlSession().insert(getStatementId(o.getClass() , POSTFIX_INSERT), o);
	}
	
	@Override
	public <T> int insert(T o) {
		return getSqlSession().insert(getStatementId(o.getClass() , POSTFIX_INSERT), o);
	}

	@Override
	public int insert(String statementId, Object parameters) {
		return getSqlSession().insert(statementId, parameters);
	}

	@Override
	public int insertAll(String statementId, Collection<? extends Object> params) {
		if(params == null) return 0 ;
		for(Object o : params){
			getBatchSqlSession().insert(statementId , o) ;
		}
		return params.size() ;
	}

	
//	------------------------------------------------------------------------------------
	@Override
	public <T> int update(T o) {
		return getSqlSession().update(getStatementId(o.getClass() , POSTFIX_UPDATE), o);
	}
	
	@Override
	public <T> int updateBatch(T o) {
		return getBatchSqlSession().update(getStatementId(o.getClass() , POSTFIX_UPDATE), o);
	}

	@Override
	public int update(String statementId, Object parameters) {
		return getSqlSession().update(statementId, parameters);
	}

	@Override
	public int updateAll(String statementId, Collection<? extends Object> params) {
		if(params == null) return 0 ;
		int i = 0 ;
		for(Object o : params){
			i += getBatchSqlSession().update(statementId , o) ;
		}
		return i ;
	}

//	---------------------------------------------------------------------------------
	@Override
	public <T> int deleteById(Class<T> entityClass, Serializable id) {
		return getSqlSession().delete(getStatementId(entityClass, POSTFIX_DELETE_ID), id);
	}

	@Override
	public <T> int delete(T o) {
		return getSqlSession().delete(getStatementId(o.getClass() , POSTFIX_DELETE),o);
	}
	
	@Override
	public <T> int deleteBatch(T o) {
		return getBatchSqlSession().delete(getStatementId(o.getClass() , POSTFIX_DELETE),o);
	}
	
	@Override
	public int delete(String statementId, Object parameters) {
		return getSqlSession().delete(statementId , parameters );
	}
	
	@Override
	public int deleteBatch(String statementId, Object parameters) {
		return getBatchSqlSession().delete(statementId , parameters );
	}

	@Override
	public int deleteAll(String statementId, Collection<? extends Object> params) {
		if(params == null) return 0 ;
		int i = 0 ;
		for(Object o : params){
			i += getBatchSqlSession().delete(statementId , o) ;
		}
		return i ;
	}

	@Override
	public <T> T queryById(Class<T> entityClass, Serializable id) {
		return getSqlSession().selectOne(getStatementId(entityClass, POSTFIX_QUERY_ID), id);
	}

	@Override
	public <T> T queryOne(String statementId, Object parameters) {
		return getSqlSession().selectOne(statementId, parameters);
	}

	@Override
	public <T> T queryOne(String statementId) {
		return getSqlSession().selectOne(statementId );
	}
	
	@Override
	public <T> List<T> queryList(Class<T> entityClass , String statementId) {
		return getSqlSession().selectList( getStatementId(entityClass, statementId));
	}
	
	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters) {
		return getSqlSession().selectList(statementId, parameters);
	}
	
	@Override
	public List<? extends Object> queryListBatch(String statementId,
			Object parameters) {
		return getBatchSqlSession().selectList(statementId, parameters);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters, RowBounds rowBounds) {
		return getSqlSession().selectList(statementId, parameters , rowBounds);
	}

	@Override
	public List<? extends Object> queryList(String statementId) {
		return getSqlSession().selectList(statementId );
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			RowBounds rowBounds) {
		return getSqlSession().selectList(statementId , rowBounds);
	}

	@Override
	public List<? extends Object> queryPage(String statementId, Page page) {
		RowBounds rowBounds = new RowBounds(page.getStart(), page.getPageSize());
		return getSqlSession().selectList(statementId, page, rowBounds);
	}

	@Override
	public int queryCount(String statementId, Page page) {
		return getSqlSession().selectOne(statementId, page);
	}

	public String getStatementId(Class<?> clazz , String statement) {
		return clazz.getSimpleName()+"." + statement ;
	}
	
	
	
//	-------------------------批量-----------------------------------
	public SqlSessionTemplate getBatchSqlSession() {
		return batchSqlSession;
	}

	public void setBatchSqlSession(SqlSessionTemplate batchSqlSession) {
		this.batchSqlSession = batchSqlSession;
	}
}