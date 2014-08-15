package com.multicampus.biz.junit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.multicampus.biz.junit.BoardDAO;
import com.multicampus.biz.junit.BoardVO;

public class BoardDAOTest {
	private BoardDAO boardDAO;

	@Before
	public void setUp() throws Exception {
		boardDAO = new BoardDAO();
	}

	@After
	public void tearDown() throws Exception {
		boardDAO = null;
	}

	@Test
	public void testGetBoard() {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		BoardVO board = boardDAO.getBoard(vo);
		assertNotNull(board);
		assertEquals("홍길동", board.getWriter());
	}

}
