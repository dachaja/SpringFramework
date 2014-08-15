package com.multicampus.biz.user.impl;

import java.sql.SQLException;

import com.multicampus.biz.user.vo.UserVO;

public class UserDAOClient {
	
	public static void main(String[] args) throws SQLException {
		UserDAO userDAO = new UserDAO();
		
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO user = userDAO.getUser(vo);
		
		if(user != null)
			System.out.println("User: " + user.getId() + ", " + user.getName() + ", " + user.getRole());
		else
			System.out.println("User is null.");
	}
}
