package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BeanInfoDto;

public class BeanInfoDaoImpl implements BeanInfoDao {

	SqlSession sqlSession;
	
	public static String nameSpace="com.rb.base.dao.BeanInfoDao";
	
	@Override
	public List<BeanInfoDto> beaninfo() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".beaninfo");
	}

}
