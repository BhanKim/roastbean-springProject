package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.AdminMainDao;
import com.rb.base.model.ManageMainDto;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	
	@Autowired
	AdminMainDao AdminMainDao;

	@Override
	public String order_date_sales(HttpServletRequest request) throws Exception {
		String order_date_sales = request.getParameter("order_date_sales");
		System.out.println(order_date_sales);
		return AdminMainDao.order_date_sales(request);
	}

	@Override
	public ManageMainDto order_date_sales_NQP() throws Exception {
		return AdminMainDao.order_date_sales_NQP();
	}

	@Override
	public String order_week_sales(HttpServletRequest request) throws Exception {// 오늘부터-7day 까지 매출금액
		String order_week_sales = (String) request.getAttribute("order_week_sales");
		System.out.println(order_week_sales);
		return AdminMainDao.order_week_sales(request);
	}



}//class end 
