package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ManageUserListService { // controller 가 아는 녀석 
	

	public void userList(HttpServletRequest request, Model model) throws Exception;


}//class end 
