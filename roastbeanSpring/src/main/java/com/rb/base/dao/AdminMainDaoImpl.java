package com.rb.base.dao;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ManageMainDto;

public class AdminMainDaoImpl implements AdminMainDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.AdminMainDao";


	@Override
	public String order_date_sales(HttpServletRequest request) throws Exception { // 오늘 총 판매 금액
		System.out.println("AdminMainDaoImpl's order+date+sales start");
		String order_date_sales = (String) request.getAttribute("order_date_sales");
		System.out.println("AdminMainDaoImpl's order_date_sales = "+order_date_sales);
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public ManageMainDto order_date_sales_NQP() throws Exception {// 오늘 많이 팔린 상품의 이름,갯수,가격
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public String order_week_sales(HttpServletRequest request) throws Exception {// 오늘부터-7day 까지 매출금액
		request.getAttribute("order_week_sales");
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}
	

}//class end 
