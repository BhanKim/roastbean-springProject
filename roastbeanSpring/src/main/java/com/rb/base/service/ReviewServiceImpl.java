package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.ReviewDao;
import com.rb.base.model.ProductDto;
import com.rb.base.model.ReviewDto;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao rDao;

	@Override
	public void productReview(HttpServletRequest request, Model model) throws Exception {
		
		int order_seq = Integer.parseInt(request.getParameter("order_seq"));
		
		ProductDto pDto = rDao.productReview(order_seq);
		model.addAttribute("review", pDto);

	}
	
	@Override
	public void insertReview(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		int order_seq = Integer.parseInt(request.getParameter("order_seq"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String review_content = request.getParameter("review_content");
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		
		rDao.insertReview(user_id, order_seq, product_id, review_content, review_star);
		rDao.updateReviewCheck(order_seq);
	}
	
	@Override
	public void selectMyReview(HttpServletRequest request, Model model) throws Exception {
		
		int order_seq = Integer.parseInt(request.getParameter("order_seq"));
		int review_seq = Integer.parseInt(request.getParameter("review_seq"));
		
		ProductDto pDto = rDao.productReview(order_seq);
		model.addAttribute("review", pDto);
		
		ReviewDto rDto = rDao.selectMyReview(review_seq);
		model.addAttribute("mylistEdit", rDto);
		
	}
	
	@Override
	public void updateReview(HttpServletRequest request, Model model) throws Exception {

		int review_seq = Integer.parseInt(request.getParameter("review_seq"));
		String review_content = request.getParameter("review_content");
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		
		rDao.updateReview(review_seq, review_content, review_star);
	}
	
	@Override
	public void deleteReview(HttpServletRequest request, Model model) throws Exception {
		
		int review_seq = Integer.parseInt(request.getParameter("review_seq"));
		
		rDao.deleteReview(review_seq);
		
	}

}
