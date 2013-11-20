package com.eden.fxmvc.service.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.eden.fxmvc.dao.EntityDao;
import com.eden.fxmvc.dao.support.Page;

@Service("serviceSupport")
public class DefaultServiceSupport implements ServiceSupport{
	
	@Resource(name="entityDao")
	private EntityDao entityDao ;


	@Override
	public int insert(String statement) {
		return entityDao.insert(statement);
	}

	public <T> int insertBatch(T o){
		return entityDao.insertBatch( o );
	}
	
	@Override
	public <T> int insert(T o) {
		return entityDao.insert( o);
	}

	@Override
	public int insert(String statementId, Object parameters) {
		return entityDao.insert(statementId, parameters);
	}

	@Override
	public int insertAll(String statementId, Collection<? extends Object> params) {
		return entityDao.insertAll(statementId, params) ;
	}

//	-------------------------------------------------------------------
	@Override
	public <T> int update(T o) {
		return entityDao.update(o);
	}
	
	@Override
	public <T> int updateBatch(T o) {
		return entityDao.updateBatch(o);
	}

	@Override
	public int update(String statementId, Object parameters) {
		return entityDao.update(statementId, parameters);
	}

	@Override
	public int updateAll(String statementId, Collection<? extends Object> params) {
		
		return entityDao.updateAll(statementId , params);
	}

	@Override
	public <T> int deleteById(Class<T> entityClass, Serializable id) {
		return entityDao.deleteById(entityClass, id);
	}

	public <T> int delete(T o) {
		return entityDao.delete(o);
	}
	
	public <T> int deleteBatch(T o) {
		return entityDao.deleteBatch(o);
	}
	
	@Override
	public int delete(String statementId, Object parameters) {
		return entityDao.delete(statementId , parameters );
	}
	
	@Override
	public int deleteBatch(String statementId, Object parameters) {
		return entityDao.deleteBatch(statementId , parameters );
	}

	@Override
	public int deleteAll(String statementId, Collection<? extends Object> params) {
		return entityDao.deleteAll(statementId, params);
	}

	@Override
	public <T> T queryById(Class<T> entityClass, Serializable id) {
		return entityDao.queryById(entityClass , id);
	}

	@Override
	public <T> T queryOne(String statementId, Object parameters) {
		return entityDao.queryOne(statementId, parameters);
	}

	@Override
	public <T> T queryOne(String statementId) {
		return entityDao.queryOne(statementId );
	}
	
	@Override
	public <T> List<T> queryList(Class<T> entityClass , String statementId){
		return entityDao.queryList(entityClass , statementId );
	}
	
	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters) {
		return entityDao.queryList(statementId, parameters);
	}
	
	@Override
	public List<? extends Object> queryListBatch(String statementId,
			Object parameters) {
		return entityDao.queryListBatch(statementId, parameters);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters, RowBounds rowBounds) {
		return entityDao.queryList(statementId, parameters , rowBounds);
	}
	@Override
	public List<? extends Object> queryList(String statementId) {
		return entityDao.queryList(statementId);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			RowBounds rowBounds) {
		return entityDao.queryList(statementId, rowBounds);
	}

	@Override
	public List<? extends Object> queryPage(String statementId, Page page) {
		
		return entityDao.queryPage(statementId, page);
	}

	@Override
	public int queryCount(String statementId, Page page) {
		
		return entityDao.queryCount(statementId, page);
	}


	
}
