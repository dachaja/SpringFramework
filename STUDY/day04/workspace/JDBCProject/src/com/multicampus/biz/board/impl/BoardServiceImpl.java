package com.multicampus.biz.board.impl;

import java.util.List;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;

	public void addBoard(BoardVO vo) {
		boardDAO.addBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
