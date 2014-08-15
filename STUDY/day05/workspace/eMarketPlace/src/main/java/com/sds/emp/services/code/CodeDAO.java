package com.sds.emp.services.code;

import java.util.ArrayList;

import com.sds.emp.services.code.vo.CodeVO;

public interface CodeDAO {
	public ArrayList<CodeVO> getCodeList(String codeType) throws Exception;
}
