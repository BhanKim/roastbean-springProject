package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rb.base.service.FindPasswordService;

@Controller
public class FindPasswordController {
	
	@Autowired
	FindPasswordService service;
	
	@RequestMapping("/find_pw")
	public String findPasswordPage() throws Exception {
		
		return "find_pw";
	}
	
	@RequestMapping("/findPwUserCheck")
	@ResponseBody
	public String findPwUserCheck(HttpServletRequest request) throws Exception {
		
		if(service.findPwUserCheck(request) == 0) {
			return "null";
		} else {
			return service.FindPw(request) + "";
		}
	}
	
}