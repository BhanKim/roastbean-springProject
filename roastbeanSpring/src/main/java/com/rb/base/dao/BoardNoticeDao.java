package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardNoticeDao {
	
	public List<BoardDto>boardnList()throws Exception;
	public List<BoardDto>bSearch(String b_opt, String keyword)throws Exception;
	
}