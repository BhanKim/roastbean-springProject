package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.CartDto;
import com.rb.base.model.UserDto;

public class CartOrderDaoImpl implements CartOrderDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.CartOrderDao";

	@Override
	public void insertCart(int product_id, String user_id, int cart_qty) throws Exception {
		sqlSession.insert(nameSpace + ".insertCart");
	}
	
	@Override
	public List<CartDto> selectCart(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".selectCart");
	}
	
	@Override
	public void deleteCart(int product_id, String user_id) throws Exception {
		sqlSession.delete(nameSpace + ".deleteCart");
	}
	
	@Override
	public UserDto selectCartUserInfo(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".selectCartUserInfo");
	}

	@Override
	public void insertOrder(String user_id) throws Exception {
		sqlSession.insert(nameSpace + ".insertOrder");
	}
	
	@Override
	public void updateOrder(String order_telno, String order_addresszipcode, String order_address1, String order_address2,
			String order_address3, String order_email, String order_name, String user_id) throws Exception {
		sqlSession.update(nameSpace + ".updateOrder");		
	}
	
	@Override
	public void deleteCartOrder(String user_id) throws Exception {
		sqlSession.delete(nameSpace + ".deleteCartOrder");
	}
	
	@Override
	public UserDto cartCount(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".cartCount");
	}
	
}
