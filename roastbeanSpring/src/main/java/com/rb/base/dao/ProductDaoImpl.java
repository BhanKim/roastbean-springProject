package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ProductDto;

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

}
