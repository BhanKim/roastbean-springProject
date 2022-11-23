package com.rb.base.dao;

import java.util.List;
import java.util.Map;

public interface ChartDao {

	public List<Map<String, Integer>> ordercount()throws Exception;
	
}
