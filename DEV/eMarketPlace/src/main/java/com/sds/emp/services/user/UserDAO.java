package com.sds.emp.services.user;

import com.sds.emp.common.vo.SearchVO;
import com.sds.emp.services.user.vo.UserVO;
import com.sds.emp.view.paging.Page;

public interface UserDAO {
	public Page getUserList(SearchVO searchVO) throws Exception;
	public UserVO getUser(String userId) throws Exception;
	public void addUser(UserVO userVO) throws Exception;
	public void updateUser(UserVO userVO) throws Exception;
	public int checkDuplication(String userId) throws Exception;
}
