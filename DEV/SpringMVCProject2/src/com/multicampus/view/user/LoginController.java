package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;
import com.multicampus.view.controller.Controller;

public class LoginController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. 사용자 입력정보 (id, password) 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		if(user != null) // 로그인 성공
			return "getBoardList.do";
		else             // 로그인 실패
			return "login.jsp";
	}

}
