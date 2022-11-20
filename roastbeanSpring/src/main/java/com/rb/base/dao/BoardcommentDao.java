package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardcommentDto;


public interface BoardcommentDao {
	public List<BoardcommentDto> cList(int community_id)throws Exception;
}