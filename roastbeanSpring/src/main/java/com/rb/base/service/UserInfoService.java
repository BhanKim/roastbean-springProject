package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.rb.base.model.UserDto;

public interface UserInfoService {
	
	public UserDto userInfoList(HttpServletRequest request) throws Exception;
	
	public int userPwCheck(HttpServletRequest request) throws Exception;
	
	public void userInfoUpdate(HttpServletRequest request) throws Exception;

	public void myOrderList(HttpServletRequest request, Model model) throws Exception;

}
