package com.eden.fxmvc.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.eden.fxmvc.dao.support.Page;
import com.eden.fxmvc.service.support.ServiceSupport;

public class EntityServiceImpl implements EntityService {
	
	@Autowired
	private ServiceSupport serviceSupport  ;

	
//	-----------------------------------------------------------------------------
	@Override
	public int insert(String statement) {
		return serviceSupport.insert(statement);
	}

	public <T> int insertBatch(T o  ){
		return serviceSupport.insertBatch( o );
	}
	
	@Override
	public <T> int insert(T o) {
		return serviceSupport.insert( o);
	}

	@Override
	public int insert(String statementId, Object parameters) {
		return serviceSupport.insert(statementId, parameters);
	}

	@Override
	public int insertAll(String statementId, Collection<? extends Object> params) {
		return serviceSupport.insertAll(statementId, params) ;
	}

//	--------------------------------------------------------------------------
	@Override
	public <T> int update(T o) {
		return serviceSupport.update(o);
	}
	
	public <T> int updateBatch(T o){
		return serviceSupport.updateBatch(o);
	}

	@Override
	public int update(String statementId, Object parameters) {
		return serviceSupport.update(statementId, parameters);
	}

	@Override
	public int updateAll(String statementId, Collection<? extends Object> params) {
		
		return serviceSupport.updateAll(statementId , params);
	}

//	----------------------------------------------------------------------------
	@Override
	public <T> int deleteById(Class<T> entityClass, Serializable id) {
		return serviceSupport.deleteById(entityClass, id);
	}

	public <T> int delete(T o) {
		return serviceSupport.delete(o);
	}
	
	public <T> int deleteBatch(T o) {
		return serviceSupport.deleteBatch(o);
	}
	
	@Override
	public int delete(String statementId, Object parameters) {
		return serviceSupport.delete(statementId , parameters );
	}
	
	@Override
	public int deleteBatch(String statementId, Object parameters) {
		return serviceSupport.deleteBatch(statementId , parameters );
	}

	@Override
	public int deleteAll(String statementId, Collection<? extends Object> params) {
		return serviceSupport.deleteAll(statementId, params);
	}

	@Override
	public <T> T queryById(Class<T> entityClass, Serializable id) {
		return serviceSupport.queryById(entityClass , id);
	}

	@Override
	public <T> T queryOne(String statementId, Object parameters) {
		return serviceSupport.queryOne(statementId, parameters);
	}

	@Override
	public <T> T queryOne(String statementId) {
		return serviceSupport.queryOne(statementId );
	}

	@Override
	public <T> List<T> queryList(Class<T> entityClass , String statementId){
		return serviceSupport.queryList(entityClass , statementId);
	}
	
	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters) {
		return serviceSupport.queryList(statementId, parameters);
	}
	@Override
	public List<? extends Object> queryListBatch(String statementId,
			Object parameters) {
		return serviceSupport.queryListBatch(statementId, parameters);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters, RowBounds rowBounds) {
		return serviceSupport.queryList(statementId, parameters , rowBounds);
	}
	@Override
	public List<? extends Object> queryList(String statementId) {
		return serviceSupport.queryList(statementId);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			RowBounds rowBounds) {
		return serviceSupport.queryList(statementId, rowBounds);
	}

	@Override
	public List<? extends Object> queryPage(String statementId, Page page) {
		
		return serviceSupport.queryPage(statementId, page) ;
	}

	@Override
	public int queryCount(String statementId, Page page) {
		
		return serviceSupport.queryCount(statementId, page) ;
	}
	
}
