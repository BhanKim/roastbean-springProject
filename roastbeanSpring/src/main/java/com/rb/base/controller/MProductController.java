package com.rb.base.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.MProductService;

@Controller
public class MProductController {
	
	@Autowired
	MProductService service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/MProductlist")
	public String Mproductlist() throws Exception{
		return "mproductlist";
	}
}
