package com.rb.base.dao;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ManageMainDto;

public class AdminMainDaoImpl implements AdminMainDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.AdminMainDao";
	
	
	@Override//<!--1day 신규유저 카운트  -->
	public String count_new_users(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override //<!-- 오늘 하루 총 판매 금액 -->	
	public String order_date_sales(HttpServletRequest request) throws Exception { // 오늘 총 판매 금액
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override //<!-- 오늘 많이 팔린 상품이름, 가격, 갯수  -->	
	public ManageMainDto order_date_order_quantity_NQP(HttpServletRequest request) throws Exception {// 오늘 많이 팔린 상품의 이름,갯수,가격
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}
	@Override //<!-- 오늘 높은 매출 상품이름, 가격, 갯수  -->	
	public ManageMainDto order_date_order_price_NQP(HttpServletRequest request) throws Exception {// 오늘 많이 팔린 상품의 이름,갯수,가격
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}
	@Override //<!-- 오늘로부터 1주일간 총 판매 금액 -->
	public String order_week_sales(HttpServletRequest request) throws Exception {// 오늘부터-7day 까지 매출금액
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override //<!-- 오늘부터 7일전까지 많은 매출을 낸  상품이름, 가격, 갯수 --> 	
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override //<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 --> 
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override //<!-- 오늘부터 대충 30일전까지, -1month 매출 -->
	public String monthly_statistics(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public String todayNewQNA(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public String totalQNA(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public String doneanswerQNA(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}

	@Override
	public String today_sum_community(HttpServletRequest request) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManageMain");
	}


	
	
	

}//class end 
