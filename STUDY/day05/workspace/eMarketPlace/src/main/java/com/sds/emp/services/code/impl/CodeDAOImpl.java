package com.sds.emp.services.code.impl;

import java.util.ArrayList;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sds.emp.services.code.CodeDAO;
import com.sds.emp.services.code.vo.CodeVO;

@Repository
public class CodeDAOImpl extends SqlSessionDaoSupport implements CodeDAO {	
	public ArrayList<CodeVO> getCodeList(String codeType) throws Exception {
		return (ArrayList)getSqlSession().selectList("Code.getCodeList", codeType);
	}
}
