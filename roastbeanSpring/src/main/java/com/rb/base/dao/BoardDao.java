package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.BoardDto;

public interface BoardDao {
	public List<BoardDto> boardList() throws Exception;
	public BoardDto contentView(int community_id) throws Exception;
	public void boardwrite(String community_name, String community_title, String community_content) throws Exception;
	public void communitydelete(int community_id)throws Exception;
	public BoardDto modify_view(int community_id)throws Exception;
	public void modify(String community_title, String community_content, int community_id)throws Exception;
}
