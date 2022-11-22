package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.CartOrderDao;
import com.rb.base.model.CartDto;
import com.rb.base.model.UserDto;

@Service
public class CartOrderServiceImpl implements CartOrderService {
	
	@Autowired
	CartOrderDao cDao;
	
	@Override
	public void selectCartOrder(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("ID");
		
		List<CartDto> cartDto = cDao.selectCart(user_id);
		UserDto cartUserInfo = cDao.selectCartUserInfo(user_id);
		
		model.addAttribute("cartlist", cartDto);
		model.addAttribute("cartUserInfo", cartUserInfo);
		
	}

	@Override
	public void insertCart(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String user_id = (String)session.getAttribute("ID");
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		
		cDao.insertCart(product_id, user_id, cart_qty);
		
		UserDto dtos = cDao.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);

	}
	
	@Override
	public void deleteCart(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String user_id = (String)session.getAttribute("ID");
		
		cDao.deleteCart(product_id, user_id);
		
		UserDto dtos = cDao.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);
		
	}
	
	@Override
	public void insertOrder(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		
		String user_id = (String)session.getAttribute("ID");
		String order_telno = request.getParameter("order_telno1") + request.getParameter("order_telno2") + request.getParameter("order_telno3");
		String order_addresszipcode = request.getParameter("order_zipcode");
		String order_address1 = request.getParameter("order_address1");
		String order_address2 = request.getParameter("order_address2");
		String order_address3 = request.getParameter("order_address3");
		String order_email = request.getParameter("order_email1") + "@" + request.getParameter("order_email2");
		String order_name = request.getParameter("order_name");
		
		cDao.insertOrder(user_id);
		cDao.updateOrder(order_telno, order_addresszipcode, order_address1, order_address2, order_address3, order_email, order_name, user_id);
		cDao.deleteCartOrder(user_id);
		
		UserDto dtos = cDao.cartCount(user_id);
		session.setAttribute("CARTCOUNT", dtos);
	}

}
