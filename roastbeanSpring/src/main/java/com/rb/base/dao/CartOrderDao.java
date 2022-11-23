package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.CartDto;
import com.rb.base.model.UserDto;

public interface CartOrderDao {
	
	public void insertCart(int product_id, String user_id, int cart_qty) throws Exception;
	public List<CartDto> selectCart(String user_id) throws Exception;
	public void deleteCart(int product_id, String user_id) throws Exception;
	public UserDto selectCartUserInfo(String user_id) throws Exception;
	public void insertOrder(String user_id) throws Exception;
	public void updateOrder(String order_telno, String order_addresszipcode, String order_address1, String order_address2, 
			String order_address3, String order_email, String order_name, String user_id) throws Exception;
	public void deleteCartOrder(String user_id) throws Exception;
	public UserDto cartCount(String user_id) throws Exception;
	public void subtractionQty(String user_id) throws Exception;

}
