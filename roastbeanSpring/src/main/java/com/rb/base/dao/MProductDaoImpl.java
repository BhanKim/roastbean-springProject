package com.rb.base.dao;

import org.apache.ibatis.session.SqlSession;

public class MProductDaoImpl implements MProductDao {
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.MProductDao";

}
