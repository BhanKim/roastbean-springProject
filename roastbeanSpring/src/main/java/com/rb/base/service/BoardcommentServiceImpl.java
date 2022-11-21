package com.rb.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.BoardcommentDao;

@Service
public class BoardcommentServiceImpl implements BoardcommentService {

	@Autowired
	BoardcommentDao boardcommentdao;
	

}
