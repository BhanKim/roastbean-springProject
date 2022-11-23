package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rb.base.service.MProductService;

@Controller
public class MProductController {
	
	@Autowired
	MProductService service;
	
	@Autowired
	HttpSession session;
	
	// 상품 리스트 출력 및 페이징 구현
	@RequestMapping("/mpList")
	public String mpList(HttpServletRequest request, Model model) throws Exception{
		service.mpList(request, model);
		return "mproductlist";
	}
	
	// 상품 디테일페이
	@RequestMapping("/mproductdetail")
	public String Mproductdetail(HttpServletRequest request, Model model)throws Exception{
		service.mproductdetail(request, model);
		return "mproductdetail";
	}
	
	// 상품 등록 창으로 이동
	@RequestMapping("mpwrite_view")
	public String mpwrite_view() throws Exception{
		return "mpwrite_view";
	}
	
	// 상품 등록
	@RequestMapping("/mpregistration")
	public String mpregistration(MultipartHttpServletRequest request, MultipartFile file) throws Exception{
		service.insertproduct(request, file);
		service.insertcategory(request);
		return "redirect:mpList";
	}
}