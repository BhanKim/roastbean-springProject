package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.rb.base.model.ManageMainDto;

public interface AdminMainService { // controller 가 아는 녀석 

	// 1day
	public void order_date_sales(HttpServletRequest request) throws Exception;
	public ManageMainDto order_date_sales_NQP(HttpServletRequest request) throws Exception; // 오늘 많이 팔린 상품의 이름,갯수, 가격
	public void count_new_users(HttpServletRequest request) throws Exception; // 신규 가입회원 카운트 
	
	// 7 day
	public void order_week_sales(HttpServletRequest request) throws Exception;
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많은 매출을 낸  상품이름, 가격, 갯수 -->
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->

	
	// 1month 
	public void monthly_statistics(HttpServletRequest request) throws Exception; // <!-- 월간 통계 -->
}//class end 
