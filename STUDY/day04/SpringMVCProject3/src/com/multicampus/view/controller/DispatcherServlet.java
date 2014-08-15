package com.multicampus.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping ��ü�� �����Ͽ� ��û�� ó���� Controller�� �˻��Ѵ�.
		HandlerMapping mapping = new HandlerMapping();
		Controller ctrl = mapping.getController(path);
		
		// 3. Controller�� �����Ͽ� ������ ó���ϰ� ȭ�� ������ ���Ϲ޴´�.
		String viewPage = ctrl.handleRequest(request, response);
		
		// 4. ������ ȭ������ �̵��Ѵ�. 
		response.sendRedirect(viewPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
