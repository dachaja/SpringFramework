package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;
import com.multicampus.view.controller.Controller;

public class GetBoardController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. 조회할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 결과 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard.jsp";
	}

}
