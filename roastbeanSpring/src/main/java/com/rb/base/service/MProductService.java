package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface MProductService {
	public void mpList(HttpServletRequest request, Model model) throws Exception;
	
	public void insertproduct(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void insertcategory(HttpServletRequest request)throws Exception;
	
	public void mproductdetail(HttpServletRequest request, Model model)throws Exception;
	public void mproductdetailupdate(HttpServletRequest request, Model model)throws Exception;
	public void mproductdetailupdateinsert(MultipartHttpServletRequest request, Model model, 
			List<MultipartFile> multipartFiles, 
			HttpSession session, RedirectAttributes attributes)throws Exception;
	public void mproductdetaildelete(HttpServletRequest request)throws Exception;
	

}
