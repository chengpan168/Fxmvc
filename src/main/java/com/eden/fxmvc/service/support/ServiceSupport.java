package com.eden.fxmvc.service.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;

import com.eden.fxmvc.dao.support.Page;

public interface ServiceSupport {
	// ----------------------------------------------------------------------
	public int insert(String statement);

	public <T> int insertBatch(T o );

	public <T> int insert(T o);

	public int insert(String statementId, Object parameters);

	public int insertAll(String statementId, Collection<? extends Object> params);

	// -------------------------------------------------------------------------
	public <T> int update(T o);
	
	public <T> int updateBatch(T o) ;

	public int update(String statementId, Object parameters);

	public int updateAll(String statementId, Collection<? extends Object> params);

	// ---------------------------------------------------------------------------
	public <T> int deleteById(Class<T> entityClass, Serializable id);

	public <T> int delete(T o) ;
	
	public <T> int deleteBatch(T o) ;
	
	public int delete(String statementId, Object parameters);
	
	public int deleteBatch(String statementId, Object parameters);

	public int deleteAll(String statementId, Collection<? extends Object> params);

	// ---------------------------------------------------------------------------------
	public <T> T queryById(Class<T> entityClass, Serializable id);

	public <T> T queryOne(String statementId, Object parameters);

	public <T> T queryOne(String statementId);

	public <T> List<T> queryList(Class<T> entityClass, String statementId);

	public List<? extends Object> queryList(String statementId,
			Object parameters);
	
	public List<? extends Object> queryListBatch(String statementId,
			Object parameters);

	public List<? extends Object> queryList(String statementId,
			Object parameters, RowBounds rowBounds);

	public List<? extends Object> queryList(String statementId);

	public List<? extends Object> queryList(String statementId,
			RowBounds rowBounds);

	public List<? extends Object> queryPage(String statementId, Page page);

	public int queryCount(String statementId, Page page);
}
