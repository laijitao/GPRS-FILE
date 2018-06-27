package com.hp.cmcc.bboss.gprs.control;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.cmcc.bboss.gprs.feignInterface.fileBodyService;
import com.hp.cmcc.bboss.gprs.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.pojo.HandleReturnPara;
import com.hp.cmcc.bboss.gprs.service.FileService;

@RestController
public class FeignTestControl {
	@Autowired
	FileService fs;
	@Autowired
	fileBodyService fbs;

	@RequestMapping("/file/feignTest")
	public HandleReturnPara fileHandle() {
		List<String> fb = null;
		
		try {
			fb = fs.GetFileBody("D:\\test\\FileName.000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//测试配置
		List<BbdcTypeCdr> rule = new LinkedList<>(); 
		rule.add(new BbdcTypeCdr("ERR_CODE", ";",         0L, 3L));
		rule.add(new BbdcTypeCdr("PROC_ID", ";",          1L, 4L));
		rule.add(new BbdcTypeCdr("OPER_TYPE", ";",        2L, 5L));
		rule.add(new BbdcTypeCdr("SERVICE_ID", ";",       3L, 6L));
		rule.add(new BbdcTypeCdr("APP_NAME", ";",         4L, 7L));
		rule.add(new BbdcTypeCdr("SERVICE_TYPE", ";",     5L, 8L));
		rule.add(new BbdcTypeCdr("NF_LIMIT", ";",         6L, 9L));
		rule.add(new BbdcTypeCdr("VALID_PROVINCE", ";",   7L, 10L));
		rule.add(new BbdcTypeCdr("VALID_DATE", ";",       8L, 11L));
		rule.add(new BbdcTypeCdr("EXPIRE_DATE", ";",      9L, 12L));
		rule.add(new BbdcTypeCdr("TIME_STAMP", ";",       10L,13L));
		rule.add(new BbdcTypeCdr("SERVICE_RANGE", ";",    11L,14L));
		rule.add(new BbdcTypeCdr("UNIFIED_PERIOD", ";",   12L,15L));
		rule.add(new BbdcTypeCdr("CREATE_DATE", ";",     -1L, 16L,"sysdate"));//
		rule.add(new BbdcTypeCdr("FILE_NAME", ";",       -1L, 17L));//
		rule.add(new BbdcTypeCdr("BDC_CODE", ";",        -1L, 1L,"011701"));//
		rule.add(new BbdcTypeCdr("OPER_SERIAL_NBR", ";", -1L, 2L));//
		rule.add(new BbdcTypeCdr("RECORD_HASH", ";",     13L, 0L));//
		
		//测试文件名
		String fn = "E_NFPAY_GPRS_FEE_20180503.020";
		//测试文件ID
//		Integer fId = 555;
		
//		GprsRecFilePara grfp = new GprsRecFilePara(fb, rule, fn);
//	    ResponseEntity<HandleReturnPara> responseEntity = rt.postForEntity(
//	    		"http://BDC-CDR-SERVICE/record/addField", grfp, HandleReturnPara.class);
//	    return responseEntity.getBody();
		HandleReturnPara hr = fbs.fileBodyHandle(fb, rule, fn);
		return hr;
	}
}
