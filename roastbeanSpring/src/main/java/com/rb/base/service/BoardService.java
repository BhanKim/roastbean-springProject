package com.rb.base.service;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardService {
	public List<BoardDto> boardList() throws Exception;
	public BoardDto contentView(int community_id) throws Exception;

}
