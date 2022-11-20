package com.rb.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index()throws Exception{
		return "index";
	}
	
	@RequestMapping("/beans_that_fit_me")
	public String boardnList()throws Exception{
		return "beans_that_fit_me";
		
	}
	
	@RequestMapping("/index")
	public String mainpage()throws Exception{
		return "index";
	}
	
	// ABOUT
	@RequestMapping("/companyinfo")
	public String information() throws Exception{
		return "companyinfo";
	}
	
	@RequestMapping("/companylocation")
	public String location()throws Exception{
		return "companylocation";
	}
}
