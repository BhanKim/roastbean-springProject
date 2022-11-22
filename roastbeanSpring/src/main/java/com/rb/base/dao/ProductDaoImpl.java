package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ProductDto;
import com.rb.base.model.ReviewDto;

public class ProductDaoImpl implements ProductDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ProductDao";

	@Override
	public int productListRow(String pcategory) throws Exception {
		return sqlSession.selectOne(nameSpace + ".productListRow");
	}

	@Override
	public List<ProductDto> productList(int cPage, String category_type, int start, int rowCount) throws Exception {
		return sqlSession.selectList(nameSpace + ".productList");
	}
	
	@Override
	public ProductDto productDetail(int product_id) throws Exception {
		return (ProductDto) sqlSession.selectList(nameSpace + ".productDetail");
	}
	
	@Override
	public List<ReviewDto> reviewList(int cPage, int product_id, int start, int rowCount) throws Exception {
		return sqlSession.selectList(nameSpace + ".reviewList");
	}
	
	@Override
	public int reviewRow(int product_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".reviewRow");
	}
	
	@Override
	public ReviewDto avgStar(int product_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".avgStar");
	}

}
