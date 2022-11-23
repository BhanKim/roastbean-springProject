package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ReviewService {
	
	public void productReview(HttpServletRequest request, Model model) throws Exception;
	public void insertReview(HttpServletRequest request, Model model) throws Exception;
	public void selectMyReview(HttpServletRequest request, Model model) throws Exception;
	public void updateReview(HttpServletRequest request, Model model) throws Exception;
	public void deleteReview(HttpServletRequest request, Model model) throws Exception;
	
}
