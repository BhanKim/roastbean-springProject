package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rb.base.model.NoticeDto;

public interface NoticeService {

	public List<NoticeDto> noticeList(HttpServletRequest request) throws Exception;
	
	public void insertAction(HttpServletRequest request) throws Exception;

	public void updateAction(HttpServletRequest request) throws Exception;
	
}
