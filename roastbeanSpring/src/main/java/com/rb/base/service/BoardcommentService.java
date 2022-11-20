package com.rb.base.service;

import java.util.List;

import com.rb.base.model.BoardcommentDto;

public interface BoardcommentService {
	public List<BoardcommentDto> cList(int community_id)throws Exception;

}
