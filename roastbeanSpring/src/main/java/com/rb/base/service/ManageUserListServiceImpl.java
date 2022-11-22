package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.ManageUserListDao;
import com.rb.base.model.PageInfo;
import com.rb.base.model.UserDto;

@Service
public class ManageUserListServiceImpl implements ManageUserListService {
	
	@Autowired
	ManageUserListDao ManageUserListDao;
	@Override
	public void userList(HttpServletRequest request, Model model) throws Exception {
		
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 9;
		int rowCount = 0;
		String tempPage = request.getParameter("page");
		String query = request.getParameter("query");
		String category = request.getParameter("query");
		
		if(query == null || query.equals("")) {
			query = "%";
		}
		
		if(tempPage == null || tempPage.length()==0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}
		
		int start = (cPage - 1) * rowLength + 1;
		rowCount = rowLength * cPage;
		
		totalRows = ManageUserListDao.userListRow(category,query);
		PageInfo dto = new PageInfo(cPage, totalRows, rowLength, pageLength);
		
		List<UserDto> dtos = ManageUserListDao.userList(cPage, query,category, start, rowCount);
		
		model.addAttribute("page", dto);
		model.addAttribute("manageuserlist", dtos);
	}


}//class end 
