package com.multicampus.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String login(UserVO vo) {
		if(userService.getUser(vo) != null)
			return "getBoardList.do";
		else return "login.jsp";
	}
}
