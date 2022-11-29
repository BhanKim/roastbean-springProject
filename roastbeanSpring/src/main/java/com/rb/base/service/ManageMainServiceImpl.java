package com.rb.base.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.rb.base.dao.ChartDao;
import com.rb.base.dao.ManageMainDao;
import com.rb.base.dao.ManageOrderListDao;
import com.rb.base.dao.ManageUserListDao;
import com.rb.base.model.ManageMainDto;
import com.rb.base.model.OrderDto;
import com.rb.base.model.PageInfo;
import com.rb.base.model.UserDto;

@Service
public class ManageMainServiceImpl implements ManageMainService {
	
	@Autowired
	ManageMainDao ManageMainDao;
	
	@Autowired
	ManageOrderListDao ManageOrderListDao;
	
	@Autowired
	ManageUserListDao ManageUserListDao;
	
	@Autowired
	ChartDao ManageChartDao;
	
	
	// /////////////////////////////////  Manage Main  /////////////////////////////////
	
	
//////////////////////// Manage Main Chart  //////////////////////////
	
	@Override
	public void manageMainChart(HttpServletRequest request, Model model) throws Exception {
		
		Gson gson=new Gson();
		List<Map<String, Integer>> chartlist = ManageChartDao.manageMainChart();
		String manageMaindataPoints=gson.toJson(chartlist);
		model.addAttribute("manageMaindataPoints",manageMaindataPoints);
	}
	
	
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
	@Override   // 22-11-23 호식 안쓸예정, 쿼리문 수정예정입니다 
	public ManageMainDto order_date_order_quantity_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto order_date_order_quantity_NQP = ManageMainDao.order_date_order_quantity_NQP(request);
		
		if(order_date_order_quantity_NQP == null) {
			request.setAttribute("order_date_order_quantity_NQP_N","금일 판매된 상품이 없습니다.");
			request.setAttribute("order_date_order_quantity_NQP_Q", 0);
			request.setAttribute("order_date_order_quantity_NQP_P", 0);
			return ManageMainDao.order_date_order_quantity_NQP(request);
		}
		request.setAttribute("order_date_order_quantity_NQP_N", order_date_order_quantity_NQP.getProduct_name());
		request.setAttribute("order_date_order_quantity_NQP_Q", order_date_order_quantity_NQP.getOrder_qty());
		request.setAttribute("order_date_order_quantity_NQP_P", order_date_order_quantity_NQP.getOrder_price());
		return ManageMainDao.order_date_order_quantity_NQP(request);
	}//order_date_sales_NQP END
	
	// 하루동안 가장 높은 매출 제품의 이름,수량,총 판매금액
	@Override // 22-11-23 호식 안쓸예정, 쿼리문 수정예정입니다 
	public ManageMainDto order_date_order_price_NQP(HttpServletRequest request) throws Exception { 
		ManageMainDto order_date_order_price_NQP = ManageMainDao.order_date_order_price_NQP(request);
		
		if(order_date_order_price_NQP == null) {
			request.setAttribute("order_date_order_price_NQP_N", "금일 판매된 상품이 없습니다.");
			request.setAttribute("order_date_order_price_NQP_Q", 0);
			request.setAttribute("order_date_order_price_NQP_P", 0);
			return ManageMainDao.order_date_order_quantity_NQP(request);
		}
		request.setAttribute("order_date_order_price_NQP_N", order_date_order_price_NQP.getProduct_name());
		request.setAttribute("order_date_order_price_NQP_Q", order_date_order_price_NQP.getOrder_qty());
		request.setAttribute("order_date_order_price_NQP_P", order_date_order_price_NQP.getOrder_price());
		return ManageMainDao.order_date_order_quantity_NQP(request);
	}//order_date_sales_NQP END
		
	////////////////////////   1 week   //////////////////////////
	
	
	@Override
	public void week_data(Model model, HttpServletRequest request) throws Exception {
		List<ManageMainDto> weekList = ManageMainDao.week_data(request);
		model.addAttribute("weekList",weekList);
	}
	
	
	// 1주일간 가장 높은 매출 상픔의 이름,수량,판매금액
	@Override	 // 22-11-23 호식 안쓸예정, 쿼리문 수정예정입니다 
	public ManageMainDto week_order_product_order_price_NQP(HttpServletRequest request) throws Exception{		
		ManageMainDto week_order_product_order_price_NQP = ManageMainDao.week_order_product_order_price_NQP(request);
		if(week_order_product_order_price_NQP == null) {
			request.setAttribute("week_order_product_order_price_NQP_N", "금주에 판매된 상품이 없습니다. ");
			request.setAttribute("week_order_product_order_price_NQP_Q", 0);
			request.setAttribute("week_order_product_order_price_NQP_P", 0);
			return ManageMainDao.week_order_product_order_price_NQP(request);
		}
		request.setAttribute("week_order_product_order_price_NQP_N", week_order_product_order_price_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_price_NQP_Q", week_order_product_order_price_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_price_NQP_P", week_order_product_order_price_NQP.getOrder_price());
		return ManageMainDao.week_order_product_order_price_NQP(request);
		
	}

	//<!-- 오늘부터 7일전까지 많이 팔린 상품이름, 가격, 갯수 -->
	@Override	 // 22-11-23 호식 안쓸예정, 쿼리문 수정예정입니다 
	public ManageMainDto week_order_product_order_quantity_NQP(HttpServletRequest request) throws Exception {
		ManageMainDto week_order_product_order_quantity_NQP = ManageMainDao.week_order_product_order_quantity_NQP(request);
		if(week_order_product_order_quantity_NQP == null) {
			request.setAttribute("week_order_product_order_quantity_NQP_N", "금주에 판매된 상품이 없습니다. ");
			request.setAttribute("week_order_product_order_quantity_NQP_Q", 0);
			request.setAttribute("week_order_product_order_quantity_NQP_P", 0);
			return ManageMainDao.week_order_product_order_quantity_NQP(request);
		}
		request.setAttribute("week_order_product_order_quantity_NQP_N", week_order_product_order_quantity_NQP.getProduct_name());
		request.setAttribute("week_order_product_order_quantity_NQP_Q", week_order_product_order_quantity_NQP.getOrder_qty());
		request.setAttribute("week_order_product_order_quantity_NQP_P", week_order_product_order_quantity_NQP.getOrder_price());
		return ManageMainDao.week_order_product_order_quantity_NQP(request);
	}

	
	////////////////////////   1 Month   //////////////////////////
	@Override	 // 22-11-23 호식 안쓸예정, 쿼리문 수정예정입니다 
	public void monthly_statistics(HttpServletRequest request) throws Exception {
		request.setAttribute("monthly_statistics", ManageMainDao.monthly_statistics(request));
	}

	
	
	///////////////////////////////////  manage_userList  ////////////////////////////////////
	
	@Override
	public void userList(HttpServletRequest request, Model model) throws Exception {
		
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수 , select all page block
		int totalpageCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		
		
		if(query == null) {
			query = "user_name";
		}
		if(content == null) {
			content = "";}
		content = '%' + content + '%';
		if(tempPage == null || tempPage.length() == 0 ) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}
		
		totalpageCount = ManageUserListDao.userListRow(query, content);
		PageInfo dto = new PageInfo(cPage, totalpageCount, listCount, pageLength);
		rowCount = (totalpageCount - ((cPage-1)*listCount))-1;
		int start = rowCount - 9;
		if(start < 0) {
			start = 0;
		}
		
		List<UserDto> userList = ManageUserListDao.userList(cPage, start, rowCount, query, content);
		model.addAttribute("page", dto);
		model.addAttribute("manageuserlist", userList);
		request.setAttribute("query", query);
		request.setAttribute("content", content.replace("%", ""));
		
	}//userList END

	
///////////////////////////////////  manage_orderList  ////////////////////////////////////
	
	@Override
	public void orderList(HttpServletRequest request, Model model) throws Exception {
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수
		int totalCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		
		if(query == null || query.length() == 0) {
			query = "order_seq";
		}
		if(content == null || content.length() == 0) {
			content = "";
		}
		content = '%' + content + '%';	
		if(tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}
		
		totalCount = ManageOrderListDao.orderListRow(query, content);
		PageInfo dto = new PageInfo(cPage, totalCount, listCount, pageLength);
		
		rowCount = (totalCount - ((cPage-1)*listCount))-1;
		int start = rowCount - 9;
		if(start < 0) {
			start = 0;
		}
	
		List<OrderDto> orderList = ManageOrderListDao.orderList(cPage, start, rowCount, query, content);
		model.addAttribute("page", dto);
		model.addAttribute("manageorderlist", orderList);
		request.setAttribute("query", query);
		request.setAttribute("content", content.replace("%", ""));
	}//orderList END

		
	
	
}//class end 
