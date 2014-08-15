<%@page import="com.multicampus.biz.board.impl.BoardDAO"%>
<%@page import="com.multicampus.biz.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
    	// 1. 삭제할 게시글 번호(seq) 추출
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	
    	// 2. DB 연동
    	BoardVO vo = new BoardVO();
    	vo.setSeq(seq);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.deleteBoard(vo);
    	
    	// 3. 화면 네비게이션
    	response.sendRedirect("getBoardList.jsp");
    %>



