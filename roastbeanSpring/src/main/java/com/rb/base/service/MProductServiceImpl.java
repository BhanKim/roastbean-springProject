package com.rb.base.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.MProductDao;

@Service
public class MProductServiceImpl implements MProductService {
	@Autowired
	MProductDao mproductdao;
	
	@Autowired
	HttpSession session;

}
