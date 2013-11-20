package com.eden.fxmvc.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.RowBounds;

import com.eden.fxmvc.dao.support.Page;


public interface DaoService {
	
	public static final String POSTFIX_INSERT = "insert";  
	  
    public static final String POSTFIX_UPDATE = "update";  
  
    public static final String POSTFIX_DELETE = "delete";  
  
    public static final String POSTFIX_DELETE_ID = "deleteById";  
    
    public static final String POSTFIX_QUERY_ID = "queryById";
  
    public static final String POSTFIX_SELECT = "query";  
  
    public static final String POSTFIX_SELECT_ALL = "selectAll";  
  
    public static final String POSTFIX_SELECTMAP = "queryByMap";  
  
    public static final String POSTFIX_SELECTSQL = "selectBySql";  
  
    public static final String POSTFIX_COUNT = "count";  
  
    public static final String POSTFIX_QUERY = "query"; 

//    ----------------------------------------------------------------------
    public int insert(String statement);
    
    public <T> int insertBatch(T o);
    
	public <T> int insert(T o);
	
	public int insert(String statementId,Object parameters);
	
	public int insertAll(String statementId,Collection<? extends Object> params);
	
//	-------------------------------------------------------------------------
	public <T> int update(T o);
	
	public <T> int updateBatch(T o);
	
	public int update(String statementId,Object parameters);
	
	public int updateAll(String statementId,Collection<? extends Object> params);
	
//	---------------------------------------------------------------------------
	public <T> int deleteById(Class<T> entityClass , Serializable id);
	
	public <T> int delete(T o) ;
	
	public <T> int deleteBatch(T o) ;
	
	public int delete(String statementId,Object parameters);
	
	public int deleteBatch(String statementId,Object parameters);
	
	public int deleteAll(String statementId,Collection<? extends Object> params);
	
//	---------------------------------------------------------------------------------
	public <T> T queryById(Class<T> entityClass , Serializable id);
	
	public <T> T queryOne(String statementId , Object parameters);
	
	public <T> T queryOne(String statementId);
	
	public <T> List<T> queryList(Class<T> entityClass , String statementId) ;
	
	public List<? extends Object> queryList(String statementId, Object parameters);

	public List<? extends Object> queryListBatch(String statementId, Object parameters);
	
	public List<? extends Object> queryList(String statementId, Object parameters, RowBounds rowBounds);
	
	public List<? extends Object> queryList(String statementId);
	
	public List<? extends Object> queryList(String statementId , RowBounds rowBounds);

	public List<? extends Object> queryPage(String statementId, 
			Page page);
	public int queryCount(String statementId, Page page);

	
}
