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
	
	// 하루 매출액
	@Override
	public void order_date_sales(HttpServletRequest request) throws Exception {
		request.setAttribute("order_date_sales", AdminMainDao.order_date_sales(request));
	}

	// 오늘부터-7day 까지 매출금액
	@Override
	public void order_week_sales(HttpServletRequest request) throws Exception {
		request.setAttribute("order_week_sales",AdminMainDao.order_week_sales(request));
	}
	
	
	// 하루동안 가장 많이 팔린 제품의 이름,수량,총 판매금액
	@Override
	public ManageMainDto order_date_sales_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto order_date_sales_NQP = AdminMainDao.order_date_sales_NQP(request);
		request.setAttribute("order_date_sales_NQP_N", order_date_sales_NQP.getProduct_name());
		request.setAttribute("order_date_sales_NQP_Q", order_date_sales_NQP.getOrder_qty());
		request.setAttribute("order_date_sales_NQP_P", order_date_sales_NQP.getOrder_price());
		return AdminMainDao.order_date_sales_NQP(request);
	}//order_date_sales_NQP END

	// 1주일간 가장 높은 매출 상픔의 이름,수량,판매금액
	@Override
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto week_order_product_order_price_NQP = AdminMainDao.week_order_product_order_price_NQP(request);
		request.setAttribute("week_order_product_order_price_NQP_N", week_order_product_order_price_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_price_NQP_Q", week_order_product_order_price_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_price_NQP_P", week_order_product_order_price_NQP.getOrder_price());
		return AdminMainDao.week_order_product_order_price_NQP(request);
	}

	//<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->
	@Override
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception {
		ManageMainDto week_order_product_order_quantity_NQP = AdminMainDao.week_order_product_order_price_NQP(request);
		request.setAttribute("week_order_product_order_quantity_NQP_N", week_order_product_order_quantity_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_quantity_NQP_Q", week_order_product_order_quantity_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_quantity_NQP_P", week_order_product_order_quantity_NQP.getOrder_price());
		return AdminMainDao.week_order_product_order_price_NQP(request);
	}

	@Override
	public void monthly_statistics(HttpServletRequest request) throws Exception {
		request.setAttribute("monthly_statistics", AdminMainDao.monthly_statistics(request));
	}

	@Override
	public void count_new_users(HttpServletRequest request) throws Exception {
		request.setAttribute("count_new_users",AdminMainDao.count_new_users(request));
		
	}
	
	


}//class end 
