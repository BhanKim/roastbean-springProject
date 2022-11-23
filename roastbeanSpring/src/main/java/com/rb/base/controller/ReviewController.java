package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping("/productReview")
	public String productReview(HttpServletRequest request, Model model) throws Exception {
		service.productReview(request, model);
		
		return "productReview";
	} 
	
	@RequestMapping("/reviewInsert")
	public String insertReview(HttpServletRequest request, Model model) throws Exception {
		service.insertReview(request, model);
		
		return "redirect:/myboardlist";
	}
	
	@RequestMapping("/reviewEdit")
	public String editReview(HttpServletRequest request, Model model) throws Exception {
		service.selectMyReview(request, model);
		
		return "reviewEdit";
	}
	
	@RequestMapping("/reviewUpdate")
	public String updateReview(HttpServletRequest request, Model model) throws Exception {
		service.updateReview(request, model);
		
		return "redirect:/myboardlist";
	}
	
	@RequestMapping("/reviewDelete")
	public String deleteReview(HttpServletRequest request, Model model) throws Exception {
		service.deleteReview(request, model);
		
		return "redirect:/myboardlist";
	}
	
}
