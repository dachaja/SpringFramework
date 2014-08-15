package com.multicampus.biz.board.impl;

import java.util.List;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardDAO {
	// 새글 등록
	/* (non-Javadoc)
	 * @see board.BoardService#addBoard(board.BoardVO)
	 */
	public void addBoard(BoardVO vo) {
		System.out.println("새 글 등록 처리...");
	}
	
	// 글 수정
	/* (non-Javadoc)
	 * @see board.BoardService#updateBoard(board.BoardVO)
	 */
	public void updateBoard(BoardVO vo) {
		System.out.println("글 수정 처리...");
	}
	
	// 글 삭제
	/* (non-Javadoc)
	 * @see board.BoardService#deleteBoard(board.BoardVO)
	 */
	public void deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리...");
	}
	
	// 글 상세 조회
	/* (non-Javadoc)
	 * @see board.BoardService#getBoard(board.BoardVO)
	 */
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("글 상세 조회 처리...");
		
		return null;
	}
	
	// 글 목록 조회
	/* (non-Javadoc)
	 * @see board.BoardService#getBoardList(board.BoardVO)
	 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("글 목록 조회 처리...");
		return null;
	}
}