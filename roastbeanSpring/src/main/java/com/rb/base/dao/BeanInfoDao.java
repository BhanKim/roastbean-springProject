package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BeanInfoDto;
import com.rb.base.model.BeanInfoPagingDto;

public interface BeanInfoDao {
	
	
	public int beaninfolistrow()throws Exception;
	
	public List<BeanInfoDto> beaninfogetlist(int cPage, int start, int rowCount)throws Exception;
}