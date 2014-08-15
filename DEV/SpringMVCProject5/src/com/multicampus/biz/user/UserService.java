package com.multicampus.biz.user;

import com.multicampus.biz.user.vo.UserVO;

public interface UserService {

	// 로그인 기능의 메소드
	public UserVO getUser(UserVO vo);

}