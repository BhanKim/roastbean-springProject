package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.rb.base.model.ManageChartDto;
import com.rb.base.model.ManageChartDto.DataPointModel;

public class ManageChartDaoImpl implements ManageChartDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ManageChartDao";

	@Override
	public List<List<DataPointModel>> getCanvasjsChartData() {
		System.out.println("ManageChartDaoImpl getCanvasjsChartData START");
		return ManageChartDto.getCanvasjsDataList();
	}
	

}//class end 
