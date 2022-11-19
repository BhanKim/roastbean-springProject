package com.rb.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.BoardNoticeDao;
import com.rb.base.model.BoardDto;

@Service
public class BoardNoticeDaoServiceImpl implements BoardNoticeDaoService {

	@Autowired
	BoardNoticeDao dao;
	
	@Override
	public List<BoardDto> BoardNoticeList() throws Exception {
		// TODO Auto-generated method stub
		return dao.BoardNoticeList();
	}

}
