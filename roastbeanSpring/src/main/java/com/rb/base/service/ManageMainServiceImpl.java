package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.ManageMainDao;
import com.rb.base.dao.ManageUserListDao;
import com.rb.base.model.ManageMainDto;
import com.rb.base.model.PageInfo;
import com.rb.base.model.UserDto;

@Service
public class ManageMainServiceImpl implements ManageMainService {
	
	@Autowired
	ManageMainDao ManageMainDao;
	
	@Autowired
	ManageUserListDao ManageUserListDao;
	
	// /////////////////////////////////  Manage Main  /////////////////////////////////
	//////////////////////// New Community //////////////////////////
	@Override
	public void today_sum_community(HttpServletRequest request) throws Exception {
		request.setAttribute("today_sum_community", ManageMainDao.today_sum_community(request));
	}
	//////////////////////// New users //////////////////////////
	@Override
	public void count_new_users(HttpServletRequest request) throws Exception {
		request.setAttribute("count_new_users",ManageMainDao.count_new_users(request));
	}

		
	//////////////////////////QNA   //////////////////////////
	@Override
	public void todayNewQNA(HttpServletRequest request) throws Exception {
		request.setAttribute("todayNewQNA", ManageMainDao.todayNewQNA(request));
	}
	
	@Override
	public void totalQNA(HttpServletRequest request) throws Exception {
		request.setAttribute("totalQNA", ManageMainDao.totalQNA(request));
	}
	
	@Override
	public void doneanswerQNA(HttpServletRequest request) throws Exception {
		request.setAttribute("doneanswerQNA", ManageMainDao.doneanswerQNA(request));	
	}
		
	
	
	
	// 하루 매출액
	@Override
	public void order_date_sales(HttpServletRequest request) throws Exception {
		request.setAttribute("order_date_sales", ManageMainDao.order_date_sales(request));
	}

	// 오늘부터-7day 까지 매출금액
	@Override
	public void order_week_sales(HttpServletRequest request) throws Exception {
		request.setAttribute("order_week_sales",ManageMainDao.order_week_sales(request));
	}
	
	
	// 하루동안 가장 많이 팔린 제품의 이름,수량,총 판매금액
	@Override
	public ManageMainDto order_date_order_quantity_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto order_date_order_quantity_NQP = ManageMainDao.order_date_order_quantity_NQP(request);
		request.setAttribute("order_date_order_quantity_NQP_N", order_date_order_quantity_NQP.getProduct_name());
		request.setAttribute("order_date_order_quantity_NQP_Q", order_date_order_quantity_NQP.getOrder_qty());
		request.setAttribute("order_date_order_quantity_NQP_P", order_date_order_quantity_NQP.getOrder_price());
		return ManageMainDao.order_date_order_quantity_NQP(request);
	}//order_date_sales_NQP END

	// 하루동안 가장 높은 매출 제품의 이름,수량,총 판매금액
	@Override
	public ManageMainDto order_date_order_price_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto order_date_order_price_NQP = ManageMainDao.order_date_order_price_NQP(request);
		request.setAttribute("order_date_order_price_NQP_N", order_date_order_price_NQP.getProduct_name());
		request.setAttribute("order_date_order_price_NQP_Q", order_date_order_price_NQP.getOrder_qty());
		request.setAttribute("order_date_order_price_NQP_P", order_date_order_price_NQP.getOrder_price());
		return ManageMainDao.order_date_order_quantity_NQP(request);
	}//order_date_sales_NQP END
	
	
	// 1주일간 가장 높은 매출 상픔의 이름,수량,판매금액
	@Override
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto week_order_product_order_price_NQP = ManageMainDao.week_order_product_order_price_NQP(request);
		request.setAttribute("week_order_product_order_price_NQP_N", week_order_product_order_price_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_price_NQP_Q", week_order_product_order_price_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_price_NQP_P", week_order_product_order_price_NQP.getOrder_price());
		return ManageMainDao.week_order_product_order_price_NQP(request);
	}

	//<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->
	@Override
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception {
		ManageMainDto week_order_product_order_quantity_NQP = ManageMainDao.week_order_product_order_price_NQP(request);
		request.setAttribute("week_order_product_order_quantity_NQP_N", week_order_product_order_quantity_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_quantity_NQP_Q", week_order_product_order_quantity_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_quantity_NQP_P", week_order_product_order_quantity_NQP.getOrder_price());
		return ManageMainDao.week_order_product_order_price_NQP(request);
	}

	
	////////////////////////   1 Month   //////////////////////////
	@Override
	public void monthly_statistics(HttpServletRequest request) throws Exception {
		request.setAttribute("monthly_statistics", ManageMainDao.monthly_statistics(request));
	}

	
	
	///////////////////////////////////  manage_userList  ////////////////////////////////////
	
	@Override
	public void userList(HttpServletRequest request, Model model) throws Exception {
		
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 9;
		int rowCount = 0;
		String tempPage = request.getParameter("page");
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		
		if(query == null || query.equals("")) {
			query = "%";
		}
		
		if(tempPage == null || tempPage.length()==0) {
			cPage = 1;
		}try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}
		
		int start = (cPage - 1) * rowLength + 1;
		rowCount = rowLength * cPage;
		
		totalRows = ManageUserListDao.userListRow(query,content);
		PageInfo dto = new PageInfo(cPage, totalRows, rowLength, pageLength);
		
		List<UserDto> dtos = ManageUserListDao.userList(cPage, query,content, start, rowCount);
		
		model.addAttribute("page", dto);
		model.addAttribute("manageuserlist", dtos);
	}
	
	
	


}//class end 
