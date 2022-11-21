package com.rb.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.BeanInfoDto;
import com.rb.base.service.BeanInfoService;

@Controller
public class BeanInfoController {
	
	@Autowired
	BeanInfoService service;
	
	
	@RequestMapping("/beaninfo")
	public String beaninfo(Model model)throws Exception{
		List<BeanInfoDto>beaninfoDao=service.beaninfo();
		model.addAttribute("list",beaninfoDao);
		
		
		
		return "beaninfo";
	}
	
	
}
