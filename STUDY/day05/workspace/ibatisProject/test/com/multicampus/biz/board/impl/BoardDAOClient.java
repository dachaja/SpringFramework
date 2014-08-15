package com.multicampus.biz.board.impl;

import java.sql.SQLException;
import java.util.List;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardDAOClient {
	
	public static void main(String[] args) throws SQLException {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("iBaits ����");
		vo.setWriter("ä����");
		vo.setContent("iBatis ����.....");		
		boardDAO.addBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("ai");
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
