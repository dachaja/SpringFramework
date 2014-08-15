package com.sds.emp.services.code.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sds.emp.services.code.CodeService;
import com.sds.emp.services.code.vo.CodeVO;

public class CodeServiceTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring/spring-common-service.xml");
		
		CodeService codeService = (CodeService) ctx.getBean("codeService");
		// CodeType {"000", "A01", "A02", "A03", "A04"}
		ArrayList<CodeVO> codeList = codeService.getCodeList("A02");
		
		for (CodeVO vo : codeList) {
			System.out.println(vo);
		}
	}
}


