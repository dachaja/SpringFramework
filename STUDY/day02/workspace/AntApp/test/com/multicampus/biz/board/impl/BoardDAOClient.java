package com.multicampus.biz.board.impl;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardDAOClient {
	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		System.out.println(board.toString());
	}
}
