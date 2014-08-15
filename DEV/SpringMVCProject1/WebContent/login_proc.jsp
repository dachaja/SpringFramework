<%@page import="com.multicampus.biz.user.impl.UserDAO"%>
<%@page import="com.multicampus.biz.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. 사용자 입력정보 (id, password) 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	// 2. DB 연동
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게시션
	if(user != null) {
		// login success.
		response.sendRedirect("getBoardList.jsp");
	} else {
		//  login failed.
		response.sendRedirect("login.jsp");
	}
%>