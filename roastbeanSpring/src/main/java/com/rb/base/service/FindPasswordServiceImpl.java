package com.rb.base.service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.FindPasswordDao;

@Service
public class FindPasswordServiceImpl implements FindPasswordService {
	
	@Autowired
	FindPasswordDao dao;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public int findPwUserCheck(HttpServletRequest request) throws Exception {
		
		int checkUser = 0;
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		checkUser = dao.findPwUserCheck(user_id, user_name, user_email);
		
		return checkUser;
		
	}
	
	@Override
	public String FindPw(HttpServletRequest request) throws Exception {
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		String userPassword = null;
		
		userPassword = dao.findPassword(user_id, user_name, user_email);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		String receiver = user_email; // 메일 받을 주소
		String title = "[RoastBean] 비밀번호 찾기";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1"
				+ "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #F2BCBB;\"><strong>RoastBean</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">비밀번호</span> 안내입니다."
				+ "		</h1>"
				+ "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> RoastBean 입니다.<br /> 비밀번호 발송드립니다. <br>"
				+ "			<br />"
				+ "			비밀번호 : "
				+ "			<br />"
				+ "			<h2><strong>" + userPassword + "</strong></h2><br />"
				+ "			<br /> 감사합니다."
				+ "		</p>"
				+ "	</div>";
		
		helper.setSubject(title);
		helper.setTo(receiver);
		helper.setText(content, true);
		
		javaMailSender.send(message);
		
		return userPassword;
	}

}
