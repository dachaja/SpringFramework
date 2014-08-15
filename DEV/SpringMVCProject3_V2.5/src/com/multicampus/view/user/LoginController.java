package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.user.impl.UserDAO;
import com.multicampus.biz.user.vo.UserVO;

public class LoginController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է�d�� (id, password) ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ����
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if(user != null) // �α��� ����
			mav.setViewName("redirect:getBoardList.do");
		else             // �α��� ����
			mav.setViewName("login");
		
		return mav;
	}

}
