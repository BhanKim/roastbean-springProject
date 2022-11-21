package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BeanInfoDto;
import com.rb.base.model.BeanInfoPagingDto;

public class BeanInfoDaoImpl implements BeanInfoDao {

	SqlSession sqlSession;
	
	public static String nameSpace="com.rb.base.dao.BeanInfoDao";
	
	@Override
	public int beaninfolistrow() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".beaninfolistrow");
	}


	@Override
	public List<BeanInfoDto> beaninfogetlist(int cPage, int rowLength,int start) throws Exception {
		
		return sqlSession.selectList(nameSpace+".beaninfogetlist");
	}

}
