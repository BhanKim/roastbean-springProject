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
	public void insertproduct(String product_name, int product_weight, String product_info, String product_image,
			int product_price, int product_stock) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insertproduct");
		
	}

	@Override
	public void insertcategory(String category_type, int product_id, String category_acidity, String category_body,
			String category_aroma, String category_sweet) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insertcategory");
		
	}

	@Override
	public int maxproduct_id() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".maxproduct_id");
	}
	
	
	@Override
	public ProductDto mproductdetail(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return (ProductDto)sqlSession.selectList(nameSpace+".mproductdetail");
	}
	
	@Override
	public ProductDto mproductdetailupdate(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return (ProductDto)sqlSession.selectList(nameSpace+".mproductdetailupdate");
	}
	
	@Override
	public ProductDto mproductdetailimages(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".mproductdetailimages");
	}
	
	@Override
	public void mproductdetailupdateinsert(int product_id, String product_name, int product_weight,
			String product_info, int product_price, int product_stock, String product_image, String category_type,
			String category_acidity, String category_aroma, String category_body, String category_sweet)
			throws Exception {
		sqlSession.update(nameSpace+".mproductdetailupdateinsert");
		
	}

	@Override
	public void mproductdetaildelete(int product_id) throws Exception {
		
		sqlSession.update(nameSpace+".mproductdetaildelete");
		
	}
	
}
