package com.rb.base.model;

public class BeanInfoPagingDto {
	int cPage;//선택된 페이지
	int totalRows;//총 게시물 수
	int currentBlock;
	int pageLength;//페이지 크기
	int startPage;//시작 페이지
	int endPage;//끝 페이지
	int totalPages;//총 페이지 수
	int startRow;//시작 게시물
	int endRow;//끝 게시물
	
	public BeanInfoPagingDto() {
		
	}

	public BeanInfoPagingDto(int cPage, int currentBlock, int pageLength, int startPage, int endPage, int totalPages,
			int startRow, int endRow) {
		super();
		this.cPage = cPage;
		this.currentBlock = currentBlock;
		this.pageLength = pageLength;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPages = totalPages;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public BeanInfoPagingDto(int cPage, int totalRows, int pageLength) {
		super();
		this.cPage = cPage;
		this.totalRows = totalRows;
		this.pageLength = pageLength;
		
		totalPages=totalRows%pageLength==0?totalRows/pageLength:(totalRows/pageLength)+1;//나머지가 0인경우, 참이면 왼쪽, 거짓이면 오른쪽 
		//
		currentBlock = cPage % pageLength == 0 ? cPage / pageLength : (cPage / pageLength) + 1;//나머지가 0인경우, 참이면 왼쪽, 거짓이면 오른쪽 
		startPage = (currentBlock - 1) * pageLength + 1;//시작 페이지
		endPage = startPage + pageLength - 1;//끝 페이지

		startRow = (cPage - 1) * pageLength;//시작 게시물
		endRow = totalRows - startRow;//끝 게시물

		if (endPage > totalPages) {//끝나는 페이지가 총 페이지보다 클 때, 총 페이지의 크기로 맞추겠다.
			endPage = totalPages;
		}
	}

	public int getcPage() {
		return cPage;
	}

	public void setcPage(int cPage) {
		this.cPage = cPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getPageLength() {
		return pageLength;
	}

	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
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

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}
