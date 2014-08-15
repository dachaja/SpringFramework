package com.multicampus.biz.board;

import java.util.List;
import com.multicampus.biz.board.vo.BoardVO;

public interface BoardService {
	
	// �� ���
	public void addBoard(BoardVO vo);

	// �� ��d
	public void updateBoard(BoardVO vo);

	// �� ��f
	public void deleteBoard(BoardVO vo);

	// �� �� vȸ
	public BoardVO getBoard(BoardVO vo);

	// �� ��� vȸ
	public List<BoardVO> getBoardList(BoardVO vo);

}