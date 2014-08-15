package com.multicampus.biz.user.impl;

import java.sql.SQLException;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.multicampus.biz.user.vo.UserVO;
import com.multicampus.biz.util.SqlMapClientFactoryBean;

@Repository
public class UserDAO {
	private SqlMapClient ibatis;
	
	public UserDAO() {
		ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();
	}
	public UserVO getUser(UserVO vo) throws SQLException {
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
}
