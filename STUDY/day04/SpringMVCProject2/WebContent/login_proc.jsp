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
	
	// 3. 화면 네비게이션
	if(user != null) // 로그인 성공
		response.sendRedirect("getBoardList.jsp");
	else             // 로그인 실패
		response.sendRedirect("login.jsp");
%>