package com.rb.base.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	public void insertcategory(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertproduct(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		String pimage = "";
		String pid ="";
		
		// 파일 저장하는 방법
		// 패스 지정
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//assets//img//product";
			// 파일을 pid로 만들기 위한 기초 단계
			pid = request.getParameter("product_name");
			// 확장자 가져오기
			String originalName = file.getOriginalFilename();
			String extension = originalName.substring(originalName.indexOf("."), originalName.length());
			// 파일 이름 만들기
			pimage = pid + extension;
			// path에 "name"으로 saveFile을 만들 빈 껍데기를 생성.
			File saveFile = new File(path, pimage);
			// file을 savefile과 path로 지어서 넣기
			file.transferTo(saveFile);
			
			String product_name = request.getParameter("product_name");
			int product_weight = Integer.parseInt(request.getParameter("product_weight"));
			String product_info = request.getParameter("product_info");
			int product_price = Integer.parseInt(request.getParameter("product_price"));
			int product_stock = Integer.parseInt(request.getParameter("product_stock"));
			
			mproductdao.insertproduct(product_name, product_weight, product_info, pimage, product_price, product_stock);
			
			int product_id = mproductdao.maxproduct_id();
			String category_type = request.getParameter("category_type");
			String category_acidity = request.getParameter("category_acidity");
			String category_body = request.getParameter("String category_body");
			String category_aroma = request.getParameter("category_aroma");
			String category_sweet = request.getParameter("category_sweet");
			
			mproductdao.insertcategory(category_type, product_id, category_acidity, category_body, category_aroma, category_sweet);
			
		}
		
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
	public void mproductdetailupdateinsert(MultipartHttpServletRequest request, Model model, 
			List<MultipartFile> multipartFiles, HttpSession session, 
			RedirectAttributes attributes) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		String product_name=request.getParameter("product_name");
		int product_weight=Integer.parseInt(request.getParameter("product_weight"));
		String product_info=request.getParameter("product_info");
		int product_price=Integer.parseInt(request.getParameter("product_price"));
		int product_stock=Integer.parseInt(request.getParameter("product_stock"));
		
		String category_type=request.getParameter("category_type");
		String category_acidity=request.getParameter("category_acidity");
		String category_aroma=request.getParameter("category_aroma");
		String category_body=request.getParameter("category_body");
		String category_sweet=request.getParameter("category_sweet");
		String product_image=null;//이미지
		
		multipartFiles =request.getFiles("file");
		
		ProductDto images=mproductdao.mproductdetailimages(product_id);//이미지를 dto에서 사용
		
		String path=System.getProperty("user.dir")+"//src//main//webapp//assets//img//product//";//이미지 경로
		
		if(!multipartFiles.isEmpty()) {
			File deleteFile =new File(path+images.getProduct_image());//dto에 있는 image를 가져옴
			deleteFile.delete();
		
		for(MultipartFile file:multipartFiles) {
			//파일을 uid로 만들기 위한 기초단계
			//확장자 가져오기
			String originName=file.getOriginalFilename();
			
				originName=product_id+originName;//사진이름을 지정하는 선언
				product_image=originName;
			//파일 네임 짓기
			//패스에 "name"으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile =new File(path,originName);
			file.transferTo(saveFile);
			
			}
		
		}
		attributes.addAttribute("product_id",product_id);
		
		mproductdao.mproductdetailupdateinsert(product_id,product_name,product_weight,product_info,
				product_price,product_stock,product_image,category_type,category_acidity,
				category_aroma, category_body, category_sweet);
		
	}

	@Override
	public void mproductdetaildelete(HttpServletRequest request) throws Exception {
		
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		mproductdao.mproductdetaildelete(product_id);
	}

} // END
