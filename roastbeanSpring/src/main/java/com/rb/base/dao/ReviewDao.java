package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.ProductDto;
import com.rb.base.model.ReviewDto;

public interface ReviewDao {
	
	public ProductDto productReview(int order_seq) throws Exception;
	public void insertReview(String user_id, int order_seq, int product_id, String review_content, int review_star) throws Exception;
	public int reviewRow(String user_id) throws Exception;
	public List<ReviewDto> selectReview(int cPages, int starts, int rowCounts, String user_id) throws Exception;
	public ReviewDto selectMyReview(int review_seq) throws Exception;
	public void updateReview(int review_seq, String review_content, int review_star) throws Exception;
	public void deleteReview(int review_seq) throws Exception;
	public void updateReviewCheck(int order_seq) throws Exception;
	
}
