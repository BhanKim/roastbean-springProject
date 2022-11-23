package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.ChartDaoService;

@Controller
public class ChartController {
	
	
	@Autowired
	ChartDaoService service;
	
	
	@RequestMapping("/ordercount")
	public String ordercount(HttpServletRequest request, Model model)throws Exception{
		
		service.ordercount(request, model);
		
		return "chart";
	}
	
}
