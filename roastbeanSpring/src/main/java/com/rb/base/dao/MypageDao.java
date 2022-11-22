package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.MyOrderListDto;
import com.rb.base.model.QnaDto;
import com.rb.base.model.UserDto;

public interface MypageDao {
	
	public UserDto userInfoList(String user_id) throws Exception;
	
	public int userPwCheck(String user_id, String user_pw) throws Exception;
	
	public void userInfoUpdate(String user_id, String user_nick, String user_telno, String user_email, String user_addresszipcode, String user_address1, String user_address2, String user_address3) throws Exception;

	public List<MyOrderListDto> myOrderList(String user_id) throws Exception;
	
	public List<QnaDto> qnaList(String user_id) throws Exception;
}
