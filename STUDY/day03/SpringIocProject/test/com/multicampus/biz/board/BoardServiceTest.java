package com.multicampus.biz.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.multicampus.biz.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:board_service.xml"})
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;

	@Test
	public void testAddBoard() {
		// 새글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용...................");
		List<BoardVO> beforeList = boardService.getBoardList(vo);
		boardService.addBoard(vo);
		List<BoardVO> afterList = boardService.getBoardList(vo);
		assertEquals(beforeList.size() + 1, afterList.size());		
	}
	
	@Test
	public void testGetBoard() {
		// 글 상세 조회
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		BoardVO board = boardService.getBoard(vo);
		assertNotNull(board);
	}	
	
}
