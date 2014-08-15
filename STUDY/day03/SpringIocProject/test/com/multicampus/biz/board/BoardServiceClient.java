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
		
		// ���� ���
		BoardVO vo = new BoardVO();
		vo.setTitle("�ӽ� ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽ� ����...................");
		
		boardService.addBoard(vo);
		
		// �� ��� ��ȸ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("<< �Խñ� ��� >>");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
