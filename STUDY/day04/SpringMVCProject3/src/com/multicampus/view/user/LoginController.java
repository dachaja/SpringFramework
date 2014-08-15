package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;
import com.multicampus.view.controller.Controller;

public class LoginController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է����� (id, password) ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ����
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
		if(user != null) // �α��� ����
			return "getBoardList.do";
		else             // �α��� ����
			return "login.jsp";
	}

}