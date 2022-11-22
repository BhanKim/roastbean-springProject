package com.rb.base.dao;

import javax.servlet.http.HttpServletRequest;

import com.rb.base.model.ManageMainDto;

public interface AdminMainDao {// service가 아는 녀석
	
	
	
	// New Community
	public String today_sum_community(HttpServletRequest request) throws Exception; // 신규 community게시글 수 
	
	
	// QNA
	
	public String todayNewQNA(HttpServletRequest request) throws Exception; // 신규 QNA 수 
	public String totalQNA(HttpServletRequest request) throws Exception; // 총 QNA 수 
	public String doneanswerQNA(HttpServletRequest request) throws Exception; // 답변 완료된 QNA 수
	
	// 1day 
	public String order_date_sales(HttpServletRequest request) throws Exception; // 오늘 총 판매 금액
	public ManageMainDto order_date_order_quantity_NQP(HttpServletRequest request) throws Exception; // 오늘 많이 팔린 상품의 이름,갯수, 가격	
	public ManageMainDto order_date_order_price_NQP(HttpServletRequest request) throws Exception; // 오늘 높은 매출 상품의 이름,갯수, 가격	
	
	public String count_new_users(HttpServletRequest request) throws Exception; // 신규 가입회원 카운트 
	// 7day
	public String order_week_sales(HttpServletRequest request) throws Exception; // 오늘부터-7day 까지 매출금액
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많은 매출을 낸  상품이름, 가격, 갯수 --> 
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->
	
	// 1month
	public String monthly_statistics(HttpServletRequest request) throws Exception; // <!-- 월간 통계 -->
	
}//END 
