package com.multicampus.biz.board.impl;

import java.util.List;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardDAO {
	// 글 등록
	public void addBoard(BoardVO vo){
		System.out.println("글 등록 처리...");
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo){
		System.out.println("글 수정 처리...");
	}	
	
	// 글 삭제
	public void deleteBoard(BoardVO vo){
		System.out.println("글 삭제 처리...");
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo){
		System.out.println("글 상세 조회 처리...");
		return null;
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("글 목록 조회 처리...");
		return null;
	}
}
