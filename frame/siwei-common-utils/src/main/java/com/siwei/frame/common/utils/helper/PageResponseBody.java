package com.siwei.frame.common.utils.helper;

/**
 * 分页查询时返回对象
 * @author siwei
 * @date 2018年7月26日
 */
public class PageResponseBody {
	
	// 分页查询时数据总数
	private long totalCount;
	
	// 总页数
	private Integer totalPages;
	
	// 当前页
	private Integer pageNumber;
	
	// 当前页的数量
	private Integer pageSize;
	
	//是否为第一页
    private boolean isFirstPage = false;
    
    //是否为最后一页
    private boolean isLastPage = false;
    
    //是否有前一页
    private boolean hasPreviousPage = false;
    
    //是否有下一页
    private boolean hasNextPage = false;
	
	// 分页查询时当前页查询出的结果集
	private Object resultCollection;
	
	public PageResponseBody(long totalCount, Object resultCollection) {
		this.totalCount = totalCount;
		this.resultCollection = resultCollection;
	}
	
	public PageResponseBody(long totalCount, int totalPages, Object resultCollection) {
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.resultCollection = resultCollection;
	}
	
	public PageResponseBody(long totalCount, int totalPages, int pageNumber, int pageSize, Object resultCollection) {
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.resultCollection = resultCollection;
	}
	
	public PageResponseBody(long totalCount, int totalPages, int pageNumber, int pageSize, 
			boolean isFirstPage, boolean isLastPage, boolean hasPreviousPage, boolean hasNextPage, Object resultCollection) {
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.isFirstPage = isFirstPage;
		this.isLastPage = isLastPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
		this.resultCollection = resultCollection;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public Object getResultCollection() {
		return resultCollection;
	}

	public void setResultCollection(Object resultCollection) {
		this.resultCollection = resultCollection;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
