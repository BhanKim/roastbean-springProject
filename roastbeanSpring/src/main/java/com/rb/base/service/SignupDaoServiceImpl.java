package com.rb.base.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rb.base.dao.LoginDao;
import com.rb.base.dao.SignupDao;

@Service
public class SignupDaoServiceImpl implements SignupDaoService {

	@Autowired
	SignupDao dao;
	LoginDao loginDao;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void checkId(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_pw_check = request.getParameter("user_pw_check");
		String user_telno = request.getParameter("user_telno");
		String user_telno1 = request.getParameter("user_telno1");
		String user_telno2 = request.getParameter("user_telno2");
		String user_telno3 = request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		String user_birthday = request.getParameter("user_birthday");
		String user_gender = request.getParameter("user_gender");
		String user_initdate = request.getParameter("user_initdate");
		String checkNickDuplication = request.getParameter("checkNickDuplication");
		
		int checkIdDuplication = dao.checkId(user_id);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("user_pw_check", user_pw_check);
		request.setAttribute("user_pw_telno", user_telno);
		request.setAttribute("user_pw_telno1", user_telno1);
		request.setAttribute("user_pw_telno2", user_telno2);
		request.setAttribute("user_pw_telno3", user_telno3);
		request.setAttribute("user_email", user_email);
		request.setAttribute("user_addresszipcode", user_addresszipcode);
		request.setAttribute("user_address1", user_address1);
		request.setAttribute("user_address2", user_address2);
		request.setAttribute("user_address3", user_address3);
		request.setAttribute("user_birthday", user_birthday);
		request.setAttribute("user_gender", user_gender);
		request.setAttribute("user_initdate", user_initdate);
		request.setAttribute("checkIdDuplication", checkIdDuplication);
		request.setAttribute("checkNickDuplication", checkNickDuplication);

	}

	@Override
	public void checkNick(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_pw_check = request.getParameter("user_pw_check");
		String user_telno = request.getParameter("user_telno");
		String user_telno1 = request.getParameter("user_telno1");
		String user_telno2 = request.getParameter("user_telno2");
		String user_telno3 = request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		String user_birthday = request.getParameter("user_birthday");
		String user_birthday1 = request.getParameter("user_birthday1");
		String user_birthday2 = request.getParameter("user_birthday2");
		String user_birthday3 = request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_initdate = request.getParameter("user_initdate");
		String checkIdDuplication = request.getParameter("checkIdDuplication");
		
		int checkNickDuplication = dao.checkNick(user_nick);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("user_pw_check", user_pw_check);
		request.setAttribute("user_telno", user_telno);
		request.setAttribute("user_telno1", user_telno1);
		request.setAttribute("user_telno2", user_telno2);
		request.setAttribute("user_telno3", user_telno3);
		request.setAttribute("user_email", user_email);
		request.setAttribute("user_addresszipcode", user_addresszipcode);
		request.setAttribute("user_address1", user_address1);
		request.setAttribute("user_address2", user_address2);
		request.setAttribute("user_address3", user_address3);
		request.setAttribute("user_birthday", user_birthday);
		request.setAttribute("user_birthday1", user_birthday1);
		request.setAttribute("user_birthday2", user_birthday2);
		request.setAttribute("user_birthday3", user_birthday3);
		request.setAttribute("user_gender", user_gender);
		request.setAttribute("user_initdate", user_initdate);
		request.setAttribute("checkIdDuplication", checkIdDuplication);
		request.setAttribute("checkNickDuplication", checkNickDuplication);
	}

	@Override
	public void signupAction(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_telno = request.getParameter("user_telno1")+request.getParameter("user_telno2")+request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_birthday = request.getParameter("user_birthday1") +"-"+ request.getParameter("user_birthday2") +"-"+ request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		dao.signupAction(user_id, user_name, user_nick, user_pw, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3);
	}

	@Override
	public void signupApiAction(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_email");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_telno = request.getParameter("user_telno1")+request.getParameter("user_telno2")+request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_birthday = request.getParameter("user_birthday1") +"-"+ request.getParameter("user_birthday2") +"-"+ request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		dao.signupApiAction(user_id, user_name, user_nick, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3);
	}
	
	@Override
	public String sendEmail(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		String email = request.getParameter("uemail");
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		
		for(int i=0;i<6;i++){
		    if(random.nextBoolean()){
		        buf.append((char)((int)(random.nextInt(26))+65));
		    }else{
		        buf.append((random.nextInt(6)));
		    }
		}
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		String certifyNum = buf.toString();

		String receiver = email; // 메일 받을 주소
		String title = "[RoastBean] 회원가입 이메일 인증";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1"
				+ "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #F2BCBB;\"><strong>RoastBean</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">메일인증</span> 안내입니다."
				+ "		</h1>"
				+ "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> RoastBean 입니다.<br /> 이메일 인증을 위한 코드를 발송드립니다. <br> <b"
				+ "				style=\"color: {$point_color\">'인증 번호'</b>를 입력하여 회원가입을 완료해 주세요.<br />"
				+ "			<br />"
				+ "			인증번호 : "
				+ "			<br />"
				+ "			<h2><strong>" + certifyNum + "</strong></h2><br />"
				+ "			<br /> 감사합니다."
				+ "		</p>"
				+ "	</div>";
		
		helper.setSubject(title);
		helper.setTo(receiver);
		helper.setText(content, true);
		
		javaMailSender.send(message);
		session.setAttribute("user_certifycheck", certifyNum);

		return certifyNum;
	}

}
