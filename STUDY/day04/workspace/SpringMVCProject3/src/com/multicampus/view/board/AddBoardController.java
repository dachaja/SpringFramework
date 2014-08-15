package com.multicampus.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.impl.BoardDAO;
import com.multicampus.biz.board.vo.BoardVO;

@Controller
public class AddBoardController {

	@RequestMapping("/addBoard.do")
	public String addBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.addBoard(vo);
		
		return "getBoardList.do";
	}

}
