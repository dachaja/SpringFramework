<%@page import="com.multicampus.biz.board.impl.BoardDAO"%>
<%@page import="com.multicampus.biz.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	BoardVO board = (BoardVO)session.getAttribute("board");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
<h3>글 상세</h3>
<a href="logout_proc.jsp">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="<%= board.getSeq() %>"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>제목</td>
<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
</tr>
<tr>
<td>작성자</td>
<td align="left"><%= board.getWriter() %></td>
</tr>
<tr>
<td>내용</td>
<td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
</tr>
<tr>
<td>등록일</td>
<td align="left"><%= board.getRegDate() %></td>
</tr>
<tr>
<td>조회수</td>
<td align="left"><%= board.getCnt() %></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="글 수정"/>
</td>
</tr>
</table>
</form>
<hr>
<a href="addBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</center>
</body>
</html>






