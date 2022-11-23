package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface MProductService {
	public void mpList(HttpServletRequest request, Model model) throws Exception;
	
	public void mproductdetail(HttpServletRequest request, Model model)throws Exception;
	public void mproductdetailupdate(HttpServletRequest request, Model model)throws Exception;
	public void mproductdetailupdateinsert(HttpServletRequest request, RedirectAttributes attributes)throws Exception;
	public void mproductdetaildelete(HttpServletRequest request)throws Exception;

}
