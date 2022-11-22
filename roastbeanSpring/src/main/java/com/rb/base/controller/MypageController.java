package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.MyOrderListDto;
import com.rb.base.model.UserDto;
import com.rb.base.service.UserInfoService;

@Controller
public class MypageController {

	@Autowired
	UserInfoService service;

	@RequestMapping("/mypage_info_list")
	public String mypage_info_list(HttpServletRequest request, Model model) throws Exception {
		UserDto dto = service.userInfoList(request);
		model.addAttribute("userinfo_list", dto);
		return "mypage_info";
	}

	@RequestMapping("/mypage_info_pwcheck_btn")
	public String mypage_info_pwcheck_btn() throws Exception {
		return "mypage_info_pwcheck";
	}

	@RequestMapping("/mypage_info_pwcheck_action")
	public String mypage_info_pwcheck_action(HttpServletRequest request) throws Exception {
		int check = service.userPwCheck(request);
		if (check == 1) {
			return "redirect:mypage_info_update_list";
		} else {
			return "mypage_info_pwcheck";
		}
	}

	@RequestMapping("/mypage_info_update_list")
	public String mypage_info_update_list(HttpServletRequest request, Model model) throws Exception {
		UserDto dto = service.userInfoList(request);
		model.addAttribute("userinfo_list", dto);
		return "mypage_info_update";
	}

	@RequestMapping("/mypage_info_update_action")
	public String mypage_info_update_action(HttpServletRequest request) throws Exception {
		service.userInfoUpdate(request);
		return "redirect:mypage_info_list";
	}

	@RequestMapping("/mypage_order_list_")
	public String mypage_order_list_(HttpServletRequest request, Model model) throws Exception {
		List<MyOrderListDto> dtos = service.myOrderList(request);
		model.addAttribute("myOrderList", dtos);
		return "mypage_order_list";
	}



}
