package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BeanInfoService {
	
//	public List<BeanInfoDto> beaninfo() throws Exception;
	
	public void excute(HttpServletRequest request, Model model)throws Exception;
}
