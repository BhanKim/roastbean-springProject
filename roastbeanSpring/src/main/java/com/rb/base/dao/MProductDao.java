package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ProductDto;

public interface MProductDao {

	public int mpListrow()throws Exception;
	public List<ProductDto> mpList(int cpage, int start, int rowCount) throws Exception;
	public ProductDto mproductdetail(int product_id)throws Exception;//상품 디테일 페이지(manage)
	public void insertproduct(String product_name, int product_weight, String product_info, String product_image, int product_price, int product_stock) throws Exception;
	public void insertcategory(String category_type, int product_id, String category_acidity, String category_body, String category_aroma, String category_sweet) throws Exception;
	public int maxproduct_id() throws Exception;
}
