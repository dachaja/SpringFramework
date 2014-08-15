package com.sds.emp.services.user.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.user.UserDAO;
import com.sds.emp.services.user.vo.UserVO;
import com.sds.emp.view.paging.Page;

@Repository("userDAO")
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	public void addUser(UserVO userVO) throws Exception {
		getSqlSession().insert("User.addUser", userVO);
	}

	public void updateUser(UserVO userVO) throws Exception {
		getSqlSession().update("User.updateUser", userVO);
	}

	public int checkDuplication(String userId) throws Exception {
		Integer cnt = (Integer)getSqlSession().selectOne("User.checkDuplication", userId);
		return cnt.intValue();
	}
	
	public UserVO getUser(String userId) throws Exception {
		return (UserVO) getSqlSession().selectOne("User.getUser", userId);
	}
	
	public Page getUserList(SearchVO searchVO) throws Exception {
		int pageIndex = searchVO.getPageIndex();
		UserVO userVO = new UserVO();
		
		String searchCondition = searchVO.getSearchCondition();
		if(searchCondition == null)
			searchCondition = "";
		
		String searchKeyword = searchVO.getSearchKeyword();
		if(searchKeyword == null)
			searchKeyword = "";
		
		if("".equals(searchCondition) || "0".equals(searchCondition))
			userVO.setUserId("%" + searchKeyword + "%");
		else
			userVO.setUserName("%" + searchKeyword + "%");

		RowBounds rowBounds = new RowBounds((pageIndex * 3) - 3, 3);		
		ArrayList<UserVO> userList = (ArrayList)getSqlSession().selectList("User.getUserList", userVO, rowBounds);
		Integer userListCnt = (Integer)getSqlSession().selectOne("User.getUserListCnt", userVO);
		Page resultPage = new Page(userList, pageIndex, userListCnt, 5, 3);

		return resultPage;
	}
}
