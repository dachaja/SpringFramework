package com.multicampus.biz.board.impl;

import java.util.List;

import com.multicampus.biz.board.vo.BoardVO;

public class BoardDAO {
	// �� ���
	public void addBoard(BoardVO vo){
		System.out.println("�� ��� ó��...");
	}
	
	// �� ����
	public void updateBoard(BoardVO vo){
		System.out.println("�� ���� ó��...");
	}	
	
	// �� ����
	public void deleteBoard(BoardVO vo){
		System.out.println("�� ���� ó��...");
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo){
		System.out.println("�� �� ��ȸ ó��...");
		return null;
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("�� ��� ��ȸ ó��...");
		return null;
	}
}
