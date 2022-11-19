package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardNoticeDao {
	
	public List<BoardDto>boardnList()throws Exception;
}