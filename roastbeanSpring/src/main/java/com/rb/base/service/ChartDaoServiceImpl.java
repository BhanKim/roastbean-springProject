package com.rb.base.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.rb.base.dao.ChartDao;
@Service
public class ChartDaoServiceImpl implements ChartDaoService {

	
	@Autowired
	ChartDao chartdao;
	
	
	@Override
	public void ordercount(HttpServletRequest request, Model model) throws Exception {
		
		Gson gson=new Gson();
		List<Map<String, Integer>> chartlist=chartdao.ordercount();
		String dataPoints=gson.toJson(chartlist);
		model.addAttribute("dataPoints",dataPoints);
	}

}
