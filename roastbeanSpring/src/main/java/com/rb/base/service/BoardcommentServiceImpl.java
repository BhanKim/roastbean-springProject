package com.rb.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.BoardcommentDao;
import com.rb.base.model.BoardcommentDto;

@Service
public class BoardcommentServiceImpl implements BoardcommentService {

	@Autowired
	BoardcommentDao boardcommentdao;
	
	@Override
	public List<BoardcommentDto> cList(int community_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("daoserviceImpl"+boardcommentdao.cList(community_id));
		return boardcommentdao.cList(community_id);
	}

}
