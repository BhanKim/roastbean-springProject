package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.ProductDto;
import com.rb.base.model.ReviewDto;

public class ReviewDaoImpl implements ReviewDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ReviewDao";

	@Override
	public ProductDto productReview(int order_seq) throws Exception {
		return sqlSession.selectOne(nameSpace + ".productReview");
	}
	
	@Override
	public void insertReview(String user_id, int order_seq, int product_id, String review_content, int review_star)
			throws Exception {
		sqlSession.insert(nameSpace + ".insertReview");
	}
	
	@Override
	public int reviewRow(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".reviewRow");
	}
	
	@Override
	public List<ReviewDto> selectReview(int cPages, int starts, int rowCounts, String user_id) {
		return sqlSession.selectList(nameSpace + ".selectReview");
	}
	
	@Override
	public ReviewDto selectMyReview(int review_seq) throws Exception {
		return sqlSession.selectOne(nameSpace + ".selectMyReview");
	}
	
	@Override
	public void updateReview(int review_seq, String review_content, int review_star) throws Exception {
		sqlSession.update(nameSpace + ".updateReview");
	}
	
	@Override
	public void deleteReview(int review_seq) throws Exception {
		sqlSession.update(nameSpace + ".deleteReview");
	}
	
	@Override
	public void updateReviewCheck(int order_seq) throws Exception {
		sqlSession.update(nameSpace + ".updateReviewCheck");
	}
}
