package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardDao {
	public int boardlistrow()throws Exception;
	public List<BoardDto> boardList(int cPage, int start, int rowCount) throws Exception;
	public BoardDto contentView(int community_id) throws Exception;
	public void boardwrite(String community_name, String community_title, String community_content) throws Exception;
	public void communitydelete(int community_id)throws Exception;
	public BoardDto modify_view(int community_id)throws Exception;
	public void modify(String community_title, String community_content, int community_id)throws Exception;
	public void upHit(int community_id)throws Exception;
	public void like(int community_id)throws Exception;
	public BoardDto reply_view(int community_id)throws Exception;
	public void reply(String community_name, String community_title, String community_content, int community_group, int community_step, int community_indent) throws Exception;
	public void replyshape(int community_group, int community_step) throws Exception;
	public List<BoardDto> nList() throws Exception;
	public int myboardlistrow(String community_name)throws Exception;
	public List<BoardDto> myboardlist(int cPage, int start, int rowCount, String community_name) throws Exception;
}
