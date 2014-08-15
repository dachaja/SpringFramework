package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;
import com.multicampus.view.controller.Controller;

public class UpdateBoardController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է�����(title, writer, content) ����
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}
