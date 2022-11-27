package com.rb.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ChartDaoImpl implements ChartDao {

	SqlSession sqlSession;
	
	public static String nameSpace="com.rb.base.dao.ChartDao";
	
	@Override
	public List<Map<String, Integer>> ordercount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".ordercount");
	}

	@Override
	public List<Map<String, Integer>> manageMainChart() throws Exception {
		return sqlSession.selectList(nameSpace+".manageMainChart");
	}

}