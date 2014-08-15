package com.multicampus.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

@Controller
public class LoginController {
	@RequestMapping("/login.do")
	public String handleRequest(UserVO vo, UserDAO userDAO) {
		if(userDAO.getUser(vo) != null)
			return "getBoardList.do";
		else return "login.jsp";
	}
}
