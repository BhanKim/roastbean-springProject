package com.rb.base.model;

public class PageInfo {
	
	int totalCount; // 총 게시물의 갯수
	int listCount;	// 한 페이지당 보여줄 게시물의 수
	int totalPage;	// 총 페이지
	int curPage;	// 현재페이지
	int pageCount;	// 하단에 보여줄 페이지 리스트의 수
	int startPage;	// 시작 페이지
	int endPage;	// 끝 페이지
	int pageLength;
	
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public PageInfo(int curPage, int totalCount, int listCount, int pageLength) {
		super();
		this.curPage = curPage;
		this.totalCount = totalCount;
		this.listCount = listCount;
		this.pageLength = pageLength;
		
		totalPage = totalCount % listCount == 0 ? totalCount / listCount : (totalCount / listCount) + 1;
		
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;
		
		startPage = ((myCurPage - 1) / pageLength) * pageLength + 1;
		endPage = startPage + pageLength - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageLength() {
		return pageLength;
	}

	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}
	
} 