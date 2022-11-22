package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ProductDto;
import com.rb.base.model.ReviewDto;

public interface ProductDao {
	
	public int productListRow(String pcategory) throws Exception;
	public List<ProductDto> productList(int cPage, String category_type, int start, int rowCount) throws Exception;
	
	public ProductDto productDetail(int product_id) throws Exception;
	public int reviewRow(int product_id) throws Exception;
	public List<ReviewDto> reviewList(int cPage, int product_id, int start, int rowCount) throws Exception;
	public ReviewDto avgStar(int product_id) throws Exception;

}
