package com.rb.base.model;

import java.sql.Timestamp;

public class ReviewDto {
	
	int rownum;
	int review_seq;
	Timestamp review_date;
	String review_content;
	int review_star;
	String user_nick;
	int order_seq;
	double sumStar;
	int sumReview;
	
	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewDto(double sumStar, int sumReview) {
		super();
		this.sumStar = sumStar;
		this.sumReview = sumReview;
	}

	public ReviewDto(int rownum, int review_seq, Timestamp review_date, String review_content, int review_star, String user_nick) {
		super();
		this.rownum = rownum;
		this.review_seq = review_seq;
		this.review_date = review_date;
		this.review_content = review_content;
		this.review_star = review_star;
		this.user_nick = user_nick;
	}

	
	public ReviewDto(int rownum, int review_seq, Timestamp review_date, String review_content, int review_star,
			String user_nick, int order_seq) {
		super();
		this.rownum = rownum;
		this.review_seq = review_seq;
		this.review_date = review_date;
		this.review_content = review_content;
		this.review_star = review_star;
		this.user_nick = user_nick;
		this.order_seq = order_seq;
	}
	
	public ReviewDto(int review_seq, String review_content, int review_star, int order_seq) {
		super();
		this.review_seq = review_seq;
		this.review_content = review_content;
		this.review_star = review_star;
		this.order_seq = order_seq;
	}


	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public int getReview_seq() {
		return review_seq;
	}

	public void setReview_seq(int review_seq) {
		this.review_seq = review_seq;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}

	public double getSumStar() {
		return sumStar;
	}

	public void setSumStar(double sumStar) {
		this.sumStar = sumStar;
	}

	public int getSumReview() {
		return sumReview;
	}

	public void setSumReview(int sumReview) {
		this.sumReview = sumReview;
	}
	
}
