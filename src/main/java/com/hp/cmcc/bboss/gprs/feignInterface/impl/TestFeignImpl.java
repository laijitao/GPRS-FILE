package com.hp.cmcc.bboss.gprs.feignInterface.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hp.cmcc.bboss.gprs.feignInterface.fileBodyService;
import com.hp.cmcc.bboss.gprs.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.pojo.HandleReturnPara;

@Component 
public class TestFeignImpl implements fileBodyService{

	public HandleReturnPara fileBodyHandle(List<String> fileBody, List<BbdcTypeCdr> rule, String fileName) {
		return null;
	}

	@Override
	public HandleReturnPara fileBodyHandleTest(List<String> fileBody, List<BbdcTypeCdr> rule, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
