package com.multicampus.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

public class GetBoardListController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է�d��(�˻� d��) ����
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		// Null Check
		if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. ��� ȭ�� ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model 저장
		mav.setViewName("getBoardList");	   // View  저장
		return mav;
	}

}
