package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.AdminMainDao;
import com.rb.base.model.ManageMainDto;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	
	@Autowired
	AdminMainDao AdminMainDao;

	@Override
	public void order_date_sales(HttpServletRequest request) throws Exception {
		request.setAttribute("order_date_sales", AdminMainDao.order_date_sales(request));
	}

	@Override
	public ManageMainDto order_date_sales_NQP() throws Exception {
		return AdminMainDao.order_date_sales_NQP();
	}

	@Override
	public void order_week_sales(HttpServletRequest request) throws Exception {// 오늘부터-7day 까지 매출금액
		request.setAttribute("order_week_sales",AdminMainDao.order_week_sales(request));
	}



}//class end 
