package com.rb.base.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rb.base.model.ManageMainDto;

public interface ManageMainDao {// service가 아는 녀석
	
	
	
	// New Community
	public Integer today_sum_community(HttpServletRequest request) throws Exception; // 신규 community게시글 수 
	
	
	// QNA
	public Integer todayNewQNA(HttpServletRequest request) throws Exception; // 신규 QNA 수 
	public Integer totalQNA(HttpServletRequest request) throws Exception; // 총 QNA 수 
	public Integer doneanswerQNA(HttpServletRequest request) throws Exception; // 답변 완료된 QNA 수
	
	// 1day 
	public Integer order_date_sales(HttpServletRequest request) throws Exception; // 오늘 총 판매 금액
	public ManageMainDto order_date_order_quantity_NQP(HttpServletRequest request) throws Exception; // 오늘 많이 팔린 상품의 이름,갯수, 가격	
	public ManageMainDto order_date_order_price_NQP(HttpServletRequest request) throws Exception; // 오늘 높은 매출 상품의 이름,갯수, 가격	
	
	public Integer count_new_users(HttpServletRequest request) throws Exception; // 신규 가입회원 카운트 
	// 7day
	public Integer order_week_sales(HttpServletRequest request) throws Exception; // 오늘부터-7day 까지 매출금액
	public List<ManageMainDto> week_data(HttpServletRequest request) throws Exception;  //<!-- 1주일치 날짜,팔린갯수, 매출금액 -->
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많은 매출을 낸  상품이름, 가격, 갯수 --> 
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception;  //<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->
	
	// 1month
	public Integer monthly_statistics(HttpServletRequest request) throws Exception; // <!-- 월간 통계 -->
	
}//END 
