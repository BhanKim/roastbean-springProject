package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ProductDto;

public interface ProductDao {
	
	public int productListRow(String pcategory) throws Exception;
	public List<ProductDto> productList(int cPage, String category_type, int start, int rowCount) throws Exception;

}
