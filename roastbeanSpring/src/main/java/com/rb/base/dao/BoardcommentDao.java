package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardcommentDto;


public interface BoardcommentDao {
	public List<BoardcommentDto> cList(int community_id)throws Exception;//댓글 list 보여주기 service는 BoardService랑 연결됨.
	//댓글 작성하기
	public void coWrite(String community_id, String community_comment_name,String community_comment_content)throws Exception;
	public void coModify(String community_comment_content,String community_comment_cono)throws Exception;
	public void coDelete(String community_comment_cono)throws Exception;
	
	
}