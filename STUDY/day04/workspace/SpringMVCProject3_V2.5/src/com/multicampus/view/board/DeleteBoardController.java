package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class DeleteBoardController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
    	// 1. ��f�� �Խñ� ��ȣ(seq) ����
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	
    	// 2. DB ����
    	BoardVO vo = new BoardVO();
    	vo.setSeq(seq);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	boardDAO.deleteBoard(vo);
    	
    	// 3. ȭ�� �׺���̼�
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:getBoardList.do");
    	return mav;
	}

}
