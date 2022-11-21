package com.rb.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index()throws Exception{
		return "index";
	}
	
	// *** 2022-11-21 추가 SangwonKim
	@RequestMapping("/index")
	public String indexPage()throws Exception{
		return "index";
	}
	
	@RequestMapping("/beans_that_fit_me")
	public String boardnList()throws Exception{
		return "beans_that_fit_me";
		
	}
}
