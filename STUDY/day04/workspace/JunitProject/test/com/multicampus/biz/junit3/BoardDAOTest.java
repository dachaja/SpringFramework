package com.multicampus.biz.junit3;

import com.multicampus.biz.junit.BoardDAO;
import com.multicampus.biz.junit.BoardVO;

import junit.framework.TestCase;

public class BoardDAOTest extends TestCase {
	private BoardDAO boardDAO;

	protected void setUp() throws Exception {
		boardDAO = new BoardDAO();
	}

	protected void tearDown() throws Exception {
		boardDAO = null;
	}

	public void testGetBoard() {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		BoardVO board = boardDAO.getBoard(vo);
		assertNotNull(board);
		assertEquals("홍길동", board.getWriter());

	}

}
