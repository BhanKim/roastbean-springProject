package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.rb.base.model.ManageMainDto;

public interface AdminMainService {

	public String order_date_sales(HttpServletRequest request) throws Exception;
	public ManageMainDto order_date_sales_NQP() throws Exception; // 오늘 많이 팔린 상품의 이름,갯수, 가격
	public String order_week_sales(HttpServletRequest request) throws Exception;
	
	
	
	
	
	
}//class end 
