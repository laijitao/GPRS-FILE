package com.hp.cmcc.bboss.bdc.feignInterface.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import com.hp.cmcc.bboss.bdc.feignInterface.fileBodyService;
import com.hp.cmcc.bboss.bdc.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.bdc.pojo.HandleReturnPara;
import com.hp.cmcc.bboss.bdc.pojo.User;

@Component 
public class TestFeignImpl implements fileBodyService{

	public HandleReturnPara fileBodyHandle(List<String> fileBody, List<BbdcTypeCdr> rule, String fileName) {
		return null;
	}

//	public List<String> test(List<User> fileBody,String name,Date ct) {
//		
//		return null;
//	}
//
//	@Override
//	public String testSql(String sql) {
//		return null;
//	}

}
