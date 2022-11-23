package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.MProductDao;
import com.rb.base.model.PageInfo;
import com.rb.base.model.ProductDto;

@Service
public class MProductServiceImpl implements MProductService {
	@Autowired
	MProductDao mproductdao;
	
	@Autowired
	HttpSession session;

	@Override
	public void mpList(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수
		int totalCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		
		if(tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}
		
		totalCount = mproductdao.mpListrow();
		PageInfo dto = new PageInfo(cPage, totalCount, listCount, pageLength);
		
		rowCount = (totalCount -((cPage-1)*10));
		int start = rowCount - 9;
		List<ProductDto> mpList = mproductdao.mpList(cPage, start, rowCount);
		model.addAttribute("page", dto);
		model.addAttribute("mpList", mpList);
		
	}

}
