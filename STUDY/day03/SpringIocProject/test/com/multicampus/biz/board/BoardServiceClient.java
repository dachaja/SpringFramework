package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("board_service.xml");
		
		BoardService boardService = 
				(BoardService)factory.getBean("boardService");
		
		// 새글 등록
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용...................");
		
		boardService.addBoard(vo);
		
		// 글 목록 조회
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("<< 게시글 목록 >>");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
