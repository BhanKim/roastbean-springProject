package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ProductDto;

public interface MProductDao {

	public int mpListrow()throws Exception;
	public List<ProductDto> mpList(int cpage, int start, int rowCount) throws Exception;
}
