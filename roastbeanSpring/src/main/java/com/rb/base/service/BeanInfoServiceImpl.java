package com.rb.base.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.BeanInfoDao;
import com.rb.base.model.BeanInfoDto;
import com.rb.base.model.BeanInfoPagingDto;
import com.rb.base.model.PageInfo;
import com.rb.base.model.ProductDto;
@Service
public class BeanInfoServiceImpl implements BeanInfoService {
	
	@Autowired
	BeanInfoDao dao;
	
//	@Override
//	public List<BeanInfoDto> beaninfo() throws Exception {
//		return dao.beaninfo();
//	}

	@Override
	public void excute(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		int cPage=0;
		int pageLength=5;
		int totalRows=0;
		int rowLength=6;
		int rowCount = 0;
		String tempPage=request.getParameter("page");
		
		
		if(tempPage==null||tempPage.length()==0) {
			cPage=1;
		}
		try {
			cPage=Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage=1;
		}
		
		
		totalRows=dao.beaninfolistrow();
		PageInfo dto= new PageInfo(cPage,totalRows,rowLength,pageLength);
		
		int start=(cPage-1)*rowLength+ 1;
		rowCount = rowLength * cPage;
		
		List<BeanInfoDto>dtos=dao.beaninfogetlist(cPage,start,rowCount);
		
		
		model.addAttribute("page",dto);
		model.addAttribute("list",dtos);
		
	}

}
