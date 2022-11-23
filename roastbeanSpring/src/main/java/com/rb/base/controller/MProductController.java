package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.MProductService;

@Controller
public class MProductController {
	
	@Autowired
	MProductService service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/mpList")
	public String mpList(HttpServletRequest request, Model model) throws Exception{
		service.mpList(request, model);
		return "mproductlist";
	}
	
	@RequestMapping("/mproductdetail")
	public String Mproductdetail(HttpServletRequest request, Model model)throws Exception{
		service.mproductdetail(request, model);
		return "mproductdetail";
	}
}