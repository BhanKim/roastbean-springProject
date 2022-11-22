package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/productList")
	public String productList(HttpServletRequest request,Model model) throws Exception{
		service.productList(request,model);
		
		return "productList";
	}
	
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest request,Model model) throws Exception{
		service.productDetail(request,model);
		
		return "productDetail";
	}
	
}
