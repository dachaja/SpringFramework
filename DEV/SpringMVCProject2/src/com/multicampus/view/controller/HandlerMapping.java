package com.multicampus.view.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.view.board.AddBoardController;
import com.multicampus.view.board.DeleteBoardController;
import com.multicampus.view.board.GetBoardController;
import com.multicampus.view.board.GetBoardListController;
import com.multicampus.view.board.UpdateBoardController;
import com.multicampus.view.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", 		new LoginController());
		mappings.put("/addBoard.do", 	new AddBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", 	new GetBoardController());
		mappings.put("/getBoardList.do",new GetBoardListController());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
