package com.eden.fxmvc.dao.support;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eden.fxmvc.dao.DaoService;
import com.eden.fxmvc.dao.EntityDao;

@Repository("entityDao")
public class IBatisEntityDao implements EntityDao {
	
	public static final Log log = LogFactory.getLog(IBatisEntityDao.class);
	
	@Autowired
	private DaoService daoService;

	
	@Override
	public int insert(String statement) {
		return daoService.insert(statement);
	}

	@Override
	public <T> int insertBatch(T o) {
		return daoService.insertBatch( o);
	}
	@Override
	public <T> int insert(T o) {
		return daoService.insert( o);
	}

	@Override
	public int insert(String statementId, Object parameters) {
		return daoService.insert(statementId, parameters);
	}

	@Override
	public int insertAll(String statementId, Collection<? extends Object> params) {
		return daoService.insertAll(statementId, params) ;
	}

	
//	-------------------------------------------------------------------------------------
	@Override
	public <T> int update(T o) {
		return daoService.update(o);
	}
	@Override
	public <T> int updateBatch(T o) {
		return daoService.updateBatch(o);
	}

	@Override
	public int update(String statementId, Object parameters) {
		return daoService.update(statementId, parameters);
	}

	@Override
	public int updateAll(String statementId, Collection<? extends Object> params) {
		
		return daoService.updateAll(statementId , params);
	}

	
//	--------------------------------------------------------------------------------------
	@Override
	public <T> int deleteById(Class<T> entityClass, Serializable id) {
		return daoService.deleteById(entityClass, id);
	}

	public <T> int delete(T o){
		return daoService.delete(o);
	}
	
	public <T> int deleteBatch(T o){
		return daoService.deleteBatch(o);
	}
	
	@Override
	public int delete(String statementId, Object parameters) {
		return daoService.delete(statementId , parameters );
	}
	@Override
	public int deleteBatch(String statementId, Object parameters) {
		return daoService.deleteBatch(statementId , parameters );
	}

	@Override
	public int deleteAll(String statementId, Collection<? extends Object> params) {
		return daoService.deleteAll(statementId, params);
	}

	@Override
	public <T> T queryById(Class<T> entityClass, Serializable id) {
		return daoService.queryById(entityClass , id);
	}

	@Override
	public <T> T queryOne(String statementId, Object parameters) {
		return daoService.queryOne(statementId, parameters);
	}

	@Override
	public <T> T queryOne(String statementId) {
		return daoService.queryOne(statementId );
	}

	public <T> List<T> queryList(Class<T> entityClass , String statementId){
		return daoService.queryList(entityClass , statementId);
	}
	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters) {
		return daoService.queryList(statementId, parameters);
	}
	
	@Override
	public List<? extends Object> queryListBatch(String statementId,
			Object parameters) {
		return daoService.queryListBatch(statementId, parameters);
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			Object parameters, RowBounds rowBounds) {
		return daoService.queryList(statementId, parameters , rowBounds);
	}

	@Override
	public List<? extends Object> queryList(String statementId) {
		return daoService.queryList(statementId );
	}

	@Override
	public List<? extends Object> queryList(String statementId,
			RowBounds rowBounds) {
		return daoService.queryList(statementId , rowBounds);
	}

	@Override
	public List<? extends Object> queryPage(String statementId, Page page) {
		return daoService.queryPage(statementId, page);
	}

	@Override
	public int queryCount(String statementId, Page page) {
		return daoService.queryCount(statementId, page);
	}
	
    
	
	
}
