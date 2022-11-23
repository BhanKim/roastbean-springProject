package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.OrderDto;
public interface ManageOrderListDao {// service가 아는 녀석
	
	public int orderListRow() throws Exception;
	public List<OrderDto> orderList(int cPage , int start, int rowCount, String query, String content) throws Exception;

}//END 
