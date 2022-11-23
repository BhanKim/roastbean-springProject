package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ManageChartDto.DataPointModel;

public interface ManageChartDao {// service가 아는 녀석
	
	
	List<List<DataPointModel>> getCanvasjsChartData();
	
}//END 
