package com.rb.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.BeanInfoService;

@Controller
public class BeanInfoController {
	
	@Autowired
	BeanInfoService service;
	
	
	@RequestMapping("/beaninfo")
	public String beaninfo(HttpServletRequest request,Model model)throws Exception{
		service.excute(request, model);
		
		
		return "beaninfo"; 
	}
	
	
}
