package com.rb.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.BeanInfoDao;
import com.rb.base.model.BeanInfoDto;
@Service
public class BeanInfoServiceImpl implements BeanInfoService {
	
	@Autowired
	BeanInfoDao dao;
	
	@Override
	public List<BeanInfoDto> beaninfo() throws Exception {
		return dao.beaninfo();
	}

}
