package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ProductDto;

public class MProductDaoImpl implements MProductDao {
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.MProductDao";

	@Override
	public int mpListrow() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".mpListrow");
	}

	@Override
	public List<ProductDto> mpList(int cpage, int start, int rowCount) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".mpList");
	}

	
	@Override
	public ProductDto mproductdetail(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return (ProductDto)sqlSession.selectList(nameSpace+".mproductdetail");
	}
}
