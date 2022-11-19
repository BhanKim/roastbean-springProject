package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.LoginDto;
import com.rb.base.service.LoginDaoService;

@Controller
public class LoginController {
	
	@Autowired
	LoginDaoService service;
	
	@RequestMapping("/login")
	public String login()throws Exception{
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String logindo(HttpServletRequest request) throws Exception{
	    HttpSession session = request.getSession();
	    String user_id = request.getParameter("user_id");
	    String user_pw = request.getParameter("user_pw");
	    LoginDto dto = service.loginCheck(user_id, user_pw);
//	    int count = dto.getCount();
	    int count = service.loginCheck2(user_id, user_pw);
	    
		if(count == 1) {
			session.setAttribute("ID", user_id);
			session.setAttribute("NICK", dto.getUser_nick());
			System.out.println("ID, NICK session값 부여");
			return "redirect:";
		}else {
			return "login";
		}
	}

	@RequestMapping("/login_admin")
	public String login_admin()throws Exception{
		return "login_admin";
	}
	
	@RequestMapping("/login_admin.do")
	public String login_admindo(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
	    String admin_id = request.getParameter("admin_id");
	    String admin_pw = request.getParameter("admin_pw");
	    int count = service.loginCheckAdmin(admin_id, admin_pw);
	
	    if(count == 1) {
			session.setAttribute("ID", admin_id);
			session.setAttribute("ADMIN", admin_id);
			session.setAttribute("NICK", "관리자");
			System.out.println("ID, ADMIN, NICK session값 부여");
			return "redirect:";
		}else {
			return "login_admin";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logoutdo(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:";
	}

	

}
