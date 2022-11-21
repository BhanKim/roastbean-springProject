package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BeanInfoDto;
import com.rb.base.model.BeanInfoPagingDto;

public interface BeanInfoDao {
	
	
	public int beaninfolistrow()throws Exception;
	
	
	public BeanInfoPagingDto beaninfolistpaging(int cPage, int totalRows, int pageLength)throws Exception;
	
	public List<BeanInfoDto> beaninfogetlist(int cPage, int rowLength, int start)throws Exception;
}




/*
 * 
 * 
 * 
 * 
 * 	<select id="beaninfolistrow" resultType="Integer"><!-- 게시물의 수를 지정해줌. -->
	
	select count(*) from beaninfo;
	
	</select>
	
	<select id="beaninfogetlist" resultType="com.rb.base.model.BeanInfoDto"><!-- 게시물의 수와 번호를 지정해줌 -->
		
			select * from beaninfo order by beaninfo_id desc limit #{start}, #{rowLength};
	</select>
 * 
 * 
 * 
 * 
 * */