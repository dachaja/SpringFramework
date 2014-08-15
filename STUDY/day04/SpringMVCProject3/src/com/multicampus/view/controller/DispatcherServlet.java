package com.multicampus.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping 객체를 생성하여 요청을 처리할 Controller를 검색한다.
		HandlerMapping mapping = new HandlerMapping();
		Controller ctrl = mapping.getController(path);
		
		// 3. Controller를 실행하여 로직을 처리하고 화면 정보를 리턴받는다.
		String viewPage = ctrl.handleRequest(request, response);
		
		// 4. 적절한 화면으로 이동한다. 
		response.sendRedirect(viewPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
