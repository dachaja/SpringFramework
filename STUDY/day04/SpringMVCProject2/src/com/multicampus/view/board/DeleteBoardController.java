package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;
import com.multicampus.view.controller.Controller;

public class DeleteBoardController implements Controller {

	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
    	// 1. ������ �Խñ� ��ȣ(seq) ����
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	
    	// 2. DB ����
    	BoardVO vo = new BoardVO();
    	vo.setSeq(seq);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.deleteBoard(vo);
    	
    	// 3. ȭ�� �׺���̼�
    	return "getBoardList.do";
	}

}
