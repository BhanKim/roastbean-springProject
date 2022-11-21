package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.ProductDao;
import com.rb.base.model.PageInfo;
import com.rb.base.model.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao pDao;

	@Override
	public void productList(HttpServletRequest request, Model model) throws Exception {
		
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 9;
		int rowCount = 0;
		String tempPage = request.getParameter("page");
		String category_type = request.getParameter("category_type");
		
		if(category_type == null || category_type.equals("")) {
			category_type = "%";
		}
		
		if(tempPage == null || tempPage.length()==0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}
		
		int start = (cPage - 1) * rowLength + 1;
		rowCount = rowLength * cPage;
		
		totalRows = pDao.productListRow(category_type);
		PageInfo dto = new PageInfo(cPage, totalRows, rowLength, pageLength);
		
		List<ProductDto> dtos = pDao.productList(cPage, category_type, start, rowCount);
		
		model.addAttribute("page", dto);
		model.addAttribute("list", dtos);
	}
	
}
