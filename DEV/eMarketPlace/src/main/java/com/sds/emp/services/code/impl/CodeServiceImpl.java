package com.sds.emp.services.code.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.emp.services.code.CodeDAO;
import com.sds.emp.services.code.CodeService;
import com.sds.emp.services.code.vo.CodeVO;

@Service("codeService")
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDAO codeDAO;

	public ArrayList<CodeVO> getCodeList(String codeType) throws Exception {
		try {
			return codeDAO.getCodeList(codeType);
		} catch (Exception e) {
			throw new Exception("코드 목록 조회 실패.", e);
		}
	}
}
