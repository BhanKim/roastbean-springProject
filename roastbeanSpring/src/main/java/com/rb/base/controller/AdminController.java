package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.AdminMainService;

@Controller
public class AdminController {
	
	@Autowired
	AdminMainService service;
	
	
	// AdminMain 
	@RequestMapping("/ManageMain")
	public String ManageMain(HttpServletRequest request)throws Exception{
		
		service.order_date_sales(request);
		service.order_week_sales(request);
		service.order_date_order_quantity_NQP(request);
		service.order_date_order_price_NQP(request);
		service.week_order_product_order_price_NQP(request);
		service.week_order_product_order_quantity_NQP(request);
		service.monthly_statistics(request);
		service.count_new_users(request);
		service.todayNewQNA(request);
		service.totalQNA(request);
		service.doneanswerQNA(request);
		service.today_sum_community(request);
		
		return "ManageMain";
	
	}
	
	
	
	
}//class end 
