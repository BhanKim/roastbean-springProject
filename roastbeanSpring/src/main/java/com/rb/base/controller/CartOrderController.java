package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.CartOrderService;

@Controller
public class CartOrderController {
	
	@Autowired
	CartOrderService service;
	
	@RequestMapping("/cartOrder")
	public String selectCartOrder(HttpServletRequest request,Model model) throws Exception{
		service.selectCartOrder(request,model);
		
		return "cartOrder";
	}
	
	@RequestMapping("/cartOrderInsert")
	public String insertCartOrder(HttpServletRequest request,Model model) throws Exception{
		service.insertCart(request,model);
		
		return "redirect:/cartOrder";
	}
	
	@RequestMapping("/insertCart")
	public String insertCart(HttpServletRequest request,Model model) throws Exception{
		service.insertCart(request,model);
		
		return "forward:/productDetail";
	}
	
	@RequestMapping("/deleteCart")
	public String deleteCart(HttpServletRequest request,Model model) throws Exception{
		service.deleteCart(request,model);
		
		return "redirect:/cartOrder";
	} 
	
	@RequestMapping("/order")
	public String order(HttpServletRequest request,Model model) throws Exception{
		service.insertOrder(request,model);
		
		return "redirect:/index";
	}
	
	
}
