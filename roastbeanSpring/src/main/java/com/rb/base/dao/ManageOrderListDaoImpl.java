package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.OrderDto;
import com.rb.base.model.UserDto;

public class ManageOrderListDaoImpl implements ManageOrderListDao {
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ManageOrderListDao";
	
	@Override
	public int orderListRow(String query, String content) throws Exception {
		return sqlSession.selectOne(nameSpace + ".orderListRow");
	}
	@Override
	public List<OrderDto> orderList(int cPage, int start, int rowCount,String query, String content) throws Exception {
		return sqlSession.selectList(nameSpace + ".orderList");
	}
	

}//class end 
