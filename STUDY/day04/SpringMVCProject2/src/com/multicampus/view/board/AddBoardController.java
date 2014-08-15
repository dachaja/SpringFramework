package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;
import com.multicampus.view.controller.Controller;

public class AddBoardController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է�����(title, writer, content) ����
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.addBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}
