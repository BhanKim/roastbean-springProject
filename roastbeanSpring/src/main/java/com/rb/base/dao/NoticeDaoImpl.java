package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.rb.base.model.NoticeDto;

public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.NoticeDao";

	@Override
	public List<NoticeDto> noticeList() throws Exception {
		return sqlSession.selectList(nameSpace + ".noticeList");
	}

	@Override
	public void insertAction(String admin_id, String notice_write_title, String notice_write_content) throws Exception {
		sqlSession.insert(nameSpace + ".insertAction");
	}

	@Override
	public void updateAction(String notice_write_title, String notice_write_content, String notice_write_seq)
			throws Exception {
		sqlSession.update(nameSpace + ".updateAction");
	}

	@Override
	public void updateActionDelete(String notice_write_seq) throws Exception {
		sqlSession.update(nameSpace + ".updateActionDelete");
	}

}
