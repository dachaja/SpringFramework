package com.multicampus.biz.board;

import java.util.List;

import com.multicampus.biz.board.vo.BoardVO;

public interface BoardService {

	// 새글 등록
	public void addBoard(BoardVO vo);

	// 글 수정
	public void updateBoard(BoardVO vo);

	// 글 삭제
	public void deleteBoard(BoardVO vo);

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo);

}