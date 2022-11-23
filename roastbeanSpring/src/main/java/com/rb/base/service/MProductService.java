package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MProductService {
	public void mpList(HttpServletRequest request, Model model) throws Exception;
	public void mproductdetail(HttpServletRequest request, Model model)throws Exception;
	public void insertproduct(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void insertcategory(HttpServletRequest request)throws Exception;

}
