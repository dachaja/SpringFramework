package com.multicampus.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("board_service.xml");
		
		BoardService boardService = (BoardService) factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		BoardVO board = boardService.getBoard(vo);
		System.out.println(board.getWriter() + " : " + board.getContent() + " : " + board.getTitle());
		
		
	}

}
