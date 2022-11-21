package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.ManageMainDto;
import com.rb.base.service.AdminMainService;

@Controller
public class AdminController {
	
	@Autowired
	AdminMainService service;
	
	
	// AdminMain 
	@RequestMapping("/ManageMain")
	public String ManageMain(Model model, HttpServletRequest request)throws Exception{
		
		service.order_date_sales(request);
		service.order_week_sales(request);
		
		ManageMainDto dateNQPDao = service.order_date_sales_NQP();
		model.addAttribute("dateNQP_N",dateNQPDao.getProduct_name());
		model.addAttribute("dateNQP_Q",dateNQPDao.getOrder_qty());
		model.addAttribute("dateNQP_P",dateNQPDao.getOrder_price());
		
		
		
		return "ManageMain";
	
	}
	
	
	
	
}//class end 
