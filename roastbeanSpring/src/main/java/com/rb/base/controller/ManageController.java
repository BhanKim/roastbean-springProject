package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rb.base.service.ManageMainService;
import com.rb.base.model.ManageChartDto.DataPointModel;
import com.rb.base.model.ManageChartDto.DatabaseConnectionException;


@Controller
public class ManageController {
	
	@Autowired
	ManageMainService service;
	
	// AdminMain 
	@RequestMapping("/ManageMain")
	public String ManageMain(HttpServletRequest request, Model model)throws Exception{
		
		service.order_date_sales(request);
		service.order_week_sales(request);
		//service.order_date_order_quantity_NQP(request);
		//service.order_date_order_price_NQP(request);
		service.week_order_product_order_price_NQP(request);
		service.week_order_product_order_quantity_NQP(request);
		service.monthly_statistics(request);
		service.count_new_users(request);
		service.todayNewQNA(request);
		service.totalQNA(request);
		service.doneanswerQNA(request);
		service.today_sum_community(request);
		service.week_data(model, request);
		return "ManageMain";
	}//ManageMain End
	
	
	//UserList
	@RequestMapping("/UserList")
	public String UserList(HttpServletRequest request, Model model)throws Exception{
		service.userList(request,model);
		
		return "manage_UserList";
	}//UserList
	
	
	
	// Chart 
	@RequestMapping("/ManageMainChart")
	public class CanvasjsChartController {
		@Autowired
		private ManageMainService canvasjsChartService;
		@RequestMapping(method = RequestMethod.GET)
		public String springMVC(ModelMap modelMap) {
							System.out.println("ManageController ManageMainChart Start");			//////Syso
			List<List<DataPointModel>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
			modelMap.addAttribute("dataPointsList", canvasjsDataList);
			return "ManageMainChart";
		}
	 
		@ExceptionHandler({DatabaseConnectionException.class})
		public ModelAndView getSuperheroesUnavailable(DatabaseConnectionException ex) {
								System.out.println("ManageController ManageMainChart End");			//////Syso
		    return new ModelAndView("chart", "error", ex.getMessage());
		}
	
	}// CanvasjsChartController END 
	
	
}//class end 
