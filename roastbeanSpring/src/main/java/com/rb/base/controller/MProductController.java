package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/mproductdetailupdate")
	public String mproductdetailupdate(HttpServletRequest request, Model model)throws Exception{
		service.mproductdetailupdate(request, model);
		return "mproductdetailupdate";
	}
	
	
	@RequestMapping("/mproductdetailupdateinsert")
	public String mproductdetailupdateinsert(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.mproductdetailupdateinsert(request, attributes);
		return "redirect:mproductdetail";
	}
	
	
	@RequestMapping("/mproductdetaildelete")
	public String mproductdetaildelete(HttpServletRequest request)throws Exception{
		service.mproductdetaildelete(request);
		return "redirect:mpList";
	}
	
}