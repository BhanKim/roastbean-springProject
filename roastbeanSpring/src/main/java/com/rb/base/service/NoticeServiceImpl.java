package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.NoticeDao;
import com.rb.base.model.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;

	@Override
	public List<NoticeDto> noticeList(HttpServletRequest request) throws Exception {
		return dao.noticeList();
	}

	@Override
	public void insertAction(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		String admin_id = (String) session.getAttribute("ADMIN");
		String notice_write_title = request.getParameter("notice_write_title");
		String notice_write_comment = request.getParameter("notice_write_comment");

		dao.insertAction(admin_id, notice_write_title, notice_write_comment);
	}

	@Override
	public void updateAction(HttpServletRequest request) throws Exception {
		String notice_write_seq = request.getParameter("notice_write_seq");
		String notice_write_title = request.getParameter("notice_write_title");
		String notice_write_content = request.getParameter("notice_write_content");
		String btnType = request.getParameter("btnType");

		if(btnType.equals("수정")) {
			dao.updateAction(notice_write_title, notice_write_content, notice_write_seq);
		}else {
			dao.updateActionDelete(notice_write_seq);
		}

	}

}
