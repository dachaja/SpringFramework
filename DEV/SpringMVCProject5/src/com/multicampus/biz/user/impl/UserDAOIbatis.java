package com.multicampus.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.user.vo.UserVO;

@Repository
public class UserDAOIbatis {
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	public UserVO getUser(UserVO vo) {
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
}
