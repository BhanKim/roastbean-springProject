package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.NoticeDto;

public interface NoticeDao {
	
	public List<NoticeDto> noticeList() throws Exception;

	public void insertAction(String admin_id, String notice_write_title, String notice_write_content) throws Exception;

	public void updateAction(String notice_write_title, String notice_write_content, String notice_write_seq) throws Exception;
	
	public void updateActionDelete(String notice_write_seq) throws Exception;
	
}
