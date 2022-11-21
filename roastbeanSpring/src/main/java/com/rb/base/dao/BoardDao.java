package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardDao {
	public List<BoardDto> boardList() throws Exception;
	public BoardDto contentView(int community_id) throws Exception;
}
