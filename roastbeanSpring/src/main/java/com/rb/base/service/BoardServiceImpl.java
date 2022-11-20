package com.rb.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.BoardDao;
import com.rb.base.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boarddao;

	// boardlist
	@Override
	public List<BoardDto> boardList() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.boardList();
	}

	// content view
	@Override
	public BoardDto contentView(int community_id) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.contentView(community_id);
	}

}
