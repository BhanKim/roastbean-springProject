package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@Override
	public void mproductdetail(HttpServletRequest request, Model model) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		ProductDto detaildto=mproductdao.mproductdetail(product_id);//dto에 product_id를 넣어주기
		
		model.addAttribute("mproductdetail",detaildto);
		
		
	}
	@Override
	public void mproductdetailupdate(HttpServletRequest request, Model model) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		ProductDto detaildtos=mproductdao.mproductdetailupdate(product_id);//dto에 product_id를 넣어주기
		model.addAttribute("mproductdetailupdate",detaildtos);
		
		
	}

	@Override
	public void mproductdetailupdateinsert(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		String product_name=request.getParameter("product_name");
		int product_weight=Integer.parseInt(request.getParameter("product_weight"));
		String product_info=request.getParameter("product_info");
		int product_price=Integer.parseInt(request.getParameter("product_price"));
		int product_stock=Integer.parseInt(request.getParameter("product_stock"));
		String product_image=request.getParameter("product_image");
		String category_type=request.getParameter("category_type");
		String category_acidity=request.getParameter("category_acidity");
		String category_aroma=request.getParameter("category_aroma");
		String category_body=request.getParameter("category_body");
		String category_sweet=request.getParameter("category_sweet");
		
		attributes.addAttribute("product_id",product_id);
		mproductdao.mproductdetailupdateinsert(product_id,product_name,product_weight,product_info,
				product_price,product_stock,product_image,category_type,category_acidity,
				category_aroma, category_body, category_sweet);
		
	}

	@Override
	public void mproductdetaildelete(HttpServletRequest request) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
//		attributes.addAttribute("product_id",product_id);
		mproductdao.mproductdetaildelete(product_id);
	}

}
