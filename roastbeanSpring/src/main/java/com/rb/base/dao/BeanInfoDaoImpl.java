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
	public BeanInfoPagingDto beaninfolistpaging(int cPage, int totalRows, int pageLength) throws Exception {
		
		int currentBlock=0;
		int startPage=0;//시작 페이지
		int endPage=0;//끝 페이지
		int totalPages=0;//총 페이지 수
		int startRow=0;//시작 게시글 번호
		int endRow=0;//끝 게시글 번호
		
		totalPages= totalRows%pageLength==0?totalRows/pageLength:(totalRows/pageLength)+1;
		currentBlock=cPage%pageLength==0?cPage/pageLength:(cPage/pageLength)+1;
		startPage=startPage+pageLength-1;
		
		
		startRow=(cPage-1)*pageLength;
		endRow=totalRows-startRow;
		
		if(endPage>totalPages) {
			endPage=totalPages;
		}
		
		BeanInfoPagingDto dto= new BeanInfoPagingDto(cPage,currentBlock,pageLength,startPage,endPage,totalPages,startRow,endRow);

		return dto;
	}

	@Override
	public List<BeanInfoDto> beaninfogetlist(int cPage, int rowLength,int start) throws Exception {
		
		return sqlSession.selectList(nameSpace+".beaninfogetlist");
	}

}
