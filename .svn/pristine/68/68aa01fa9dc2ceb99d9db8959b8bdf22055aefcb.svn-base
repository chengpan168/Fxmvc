package com.eden.fxmvc.dao.support;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Page implements Serializable , Cloneable{
	private static final long serialVersionUID = 1L;

	private int start = 0; 
	private int pageSize = 20; 
	private int total = 0 ;
	private int pageCount = 0 ; 
	private int currPage = 1 ; 

	private String findType; 
	private String findValue; 
	private String sortType = "desc"; 
	private String sortValue; 

	private Map<String, Object> queryMap ;
	
	public Page() {
	}
	
	public void update(){
		if(total > 0){
			if (total % pageSize == 0) {
				this.pageCount = total / this.pageSize;
			} else {
				this.pageCount = total / this.pageSize + 1;
			}
			if (currPage > pageCount) {
				currPage -= 1;
			}
			if(currPage > 0)
				start = (currPage - 1) * pageSize ;
			else {
				currPage = 1 ;
			}
		} else {
			start = 0; 
			pageSize = 20; 
			total = 0 ;
			pageCount = 0 ; 
			currPage = 0 ;
		}
	}
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currPage > pageCount) return ;
		this.currPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize < 1) return ;
		this.pageSize = pageSize;
		update() ;
	}

	public int getStart() {
		return start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		update() ;
	}

	public int getPageCount() {
		return pageCount;
	}

	public String getFindType() {
		if (findValue != null)
			findValue = findValue.trim();
		return findType;
	}

	public void setFindType(String findType) {
		if (findType != null)
			findType = findType.trim();
		this.findType = findType;
	}

	public String getFindValue() {
		if (findValue != null)
			findValue = findValue.trim();
		return findValue;
	}

	public void setFindValue(String findValue) {
		if (findValue != null)
			findValue = findValue.trim();
		this.findValue = findValue;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}

	public Page(int maxResults, int firstResult, int totalRecords,
			int pageCount, String findType, String findValue, String sortType,
			String sortValue) {
		super();
		this.pageSize = maxResults;
		this.start = firstResult;
		this.total = totalRecords;
		this.pageCount = pageCount;
		this.findType = findType;
		this.findValue = findValue;
		this.sortType = sortType;
		this.sortValue = sortValue;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage ;
	}
	
	
	@Override
	public Page clone(){
		Page page = new Page() ;
		page.start = this.start ;
		page.pageSize = this.pageSize ;
		page.pageCount = this.pageCount ;
		page.currPage = this.currPage ;

		page.findType = this.findType ;
		page.findValue = this.findValue ;
		page.sortType = this.sortType ;
		page.sortValue = this.sortValue ;
		return page ;
	}

	public Map<String, Object> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, Object> queryMap) {
		this.queryMap = queryMap;
	}
	
	public void addQuery(String findType , Object findValue){
		if(queryMap == null) queryMap = new HashMap<String , Object>() ;
		queryMap.put(findType, findValue) ;
	}
}
