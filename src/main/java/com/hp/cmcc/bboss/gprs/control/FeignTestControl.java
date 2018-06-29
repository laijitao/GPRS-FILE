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
		String path = "D:\\test\\";
		
		//测试文件名
		String fn = fs.getFileName(path);
		
		List<String> fb = null;
		try {
			fb = fs.GetFileBody(path+fn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//测试配置
		List<BbdcTypeCdr> rule = new LinkedList<>(); 
		//定向流量
//		rule.add(new BbdcTypeCdr("ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("APNNI_CODE", ";",       3L, 6L));
//		rule.add(new BbdcTypeCdr("INDUSTRY_APP_TYPE", ";",4L, 7L));
//		rule.add(new BbdcTypeCdr("CODE_PREFIX", ";",      5L, 8L));
//		rule.add(new BbdcTypeCdr("ROAM_SETTLE_FLAG", ";", 6L, 9L));
//		rule.add(new BbdcTypeCdr("VALID_DATE", ";",       7L, 10L));
//		rule.add(new BbdcTypeCdr("EXPIRE_DATE", ";",      8L, 11L));
//		rule.add(new BbdcTypeCdr("TIME_STAMP", ";",       9L, 12L));
//		rule.add(new BbdcTypeCdr("CREATE_DATE", ";",     -1L, 13L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("FILE_NAME", ";",       -1L, 14L));//
//		rule.add(new BbdcTypeCdr("BDC_CODE", ";",        -1L, 0L,"011701"));//
//		rule.add(new BbdcTypeCdr("OPER_SERIAL_NBR", ";", -1L, 1L));//
//		rule.add(new BbdcTypeCdr("RECORD_HASH", ";",     10L, 2L));//
		
		//GPRS_APNNI
//		rule.add(new BbdcTypeCdr("ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("SERVICE_ID", ";",       3L, 6L));
//		rule.add(new BbdcTypeCdr("APP_NAME", ";",         4L, 7L));
//		rule.add(new BbdcTypeCdr("SERVICE_TYPE", ";",     5L, 8L));
//		rule.add(new BbdcTypeCdr("NF_LIMIT", ";",         6L, 9L));
//		rule.add(new BbdcTypeCdr("VALID_PROVINCE", ";",   7L, 10L));
//		rule.add(new BbdcTypeCdr("VALID_DATE", ";",       8L, 11L));
//		rule.add(new BbdcTypeCdr("EXPIRE_DATE", ";",      9L, 12L));
//		rule.add(new BbdcTypeCdr("TIME_STAMP", ";",       10L,13L));
//		rule.add(new BbdcTypeCdr("SERVICE_RANGE", ";",    11L,14L));
//		rule.add(new BbdcTypeCdr("UNIFIED_PERIOD", ";",   12L,15L));
//		rule.add(new BbdcTypeCdr("CREATE_DATE", ";",     -1L, 16L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("FILE_NAME", ";",       -1L, 17L));//
//		rule.add(new BbdcTypeCdr("BDC_CODE", ";",        -1L, 1L,"011701"));//
//		rule.add(new BbdcTypeCdr("OPER_SERIAL_NBR", ";", -1L, 2L));//
//		rule.add(new BbdcTypeCdr("RECORD_HASH", ";",     13L, 0L,"select OPER_SERIAL_NBR from import.bdc_gprs_011701_t where RECORD_HASH=?"));//
		
		//gprs业务计费代码
//		rule.add(new BbdcTypeCdr("ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("SERVICE_CODE", ";",     3L, 6L));
//		rule.add(new BbdcTypeCdr("VALID_DATE", ";",       4L, 7L));
//		rule.add(new BbdcTypeCdr("EXPIRE_DATE", ";",      5L, 8L));
//		rule.add(new BbdcTypeCdr("DESCRIPTION", ";",      6L, 9L));
//		rule.add(new BbdcTypeCdr("IS_CHARGE", ";",        7L, 10L));
//		rule.add(new BbdcTypeCdr("FEE", ";",              8L, 11L));
//		rule.add(new BbdcTypeCdr("TIME_STAMP", ";",       9L, 12L));
//		rule.add(new BbdcTypeCdr("CREATE_DATE", ";",     -1L, 13L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("FILE_NAME", ";",       -1L, 14L));//
//		rule.add(new BbdcTypeCdr("BDC_CODE", ";",        -1L, 0L,"010201"));//
//		rule.add(new BbdcTypeCdr("OPER_SERIAL_NBR", ";", -1L, 1L));//
//		rule.add(new BbdcTypeCdr("RECORD_HASH", ";",     10L, 2L,"select OPER_SERIAL_NBR from import.bdc_gprs_011701_t where RECORD_HASH=?"));//
		//短信
//		rule.add(new BbdcTypeCdr("ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("SERV_TYPE", ";",        3L, 6L));
//		rule.add(new BbdcTypeCdr("SERV_CODE", ";",        4L, 7L));
//		rule.add(new BbdcTypeCdr("PROV_CODE", ";",        5L, 8L));//
//		rule.add(new BbdcTypeCdr("SMS_TYPE", ";",         6L, 9L));
//		rule.add(new BbdcTypeCdr("VALID_DATE", ";",       7L, 10L));
//		rule.add(new BbdcTypeCdr("EXPIRE_DATE", ";",      8L, 11L));
//		rule.add(new BbdcTypeCdr("PRODUCT_TYPE", ";",     9L, 12L));
//		rule.add(new BbdcTypeCdr("PRODUCT_CODE", ";",     10L,13L));
//		rule.add(new BbdcTypeCdr("ECID", ";",             11L,14L));
//		rule.add(new BbdcTypeCdr("IS_BAL_PORT", ";",      12L,15L));
//		rule.add(new BbdcTypeCdr("VALID_PROVINCE", ";",   13L,16L));
//		rule.add(new BbdcTypeCdr("TIME_STAMP", ";",       14L,17L));
//		rule.add(new BbdcTypeCdr("RECORD_HASH", ";",      15L, 2L,"select OPER_SERIAL_NBR from import.bdc_gprs_011701_t where RECORD_HASH=?"));//
//		rule.add(new BbdcTypeCdr("CREATE_DATE", ";",     -1L, 18L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("FILE_NAME", ";",       -1L, 19L));//
//		rule.add(new BbdcTypeCdr("BDC_CODE", ";",        -1L, 0L,"000231"));//
//		rule.add(new BbdcTypeCdr("OPER_SERIAL_NBR", ";", -1L, 1L));//
		//发布结果通知文件
//		rule.add(new BbdcTypeCdr("PROC_ID", ";",      0L, 0L));
//		rule.add(new BbdcTypeCdr("STATUS", ";",       1L, 1L));
//		rule.add(new BbdcTypeCdr("REMARK", ";",       2L, 2L));
//		rule.add(new BbdcTypeCdr("CREATE_DATE", ";", -1L, 3L,"sysdate"));
//		rule.add(new BbdcTypeCdr("FILE_NAME", ";",   -1L, 4L));
		//各省网元通知加载状态文件
		rule.add(new BbdcTypeCdr("PROC_ID", ";",      0L, 0L));
		rule.add(new BbdcTypeCdr("NODE_TYPE", ";",    1L, 1L));
		rule.add(new BbdcTypeCdr("PROVINCE_ID", ";",  2L, 2L));
		rule.add(new BbdcTypeCdr("STATUS", ";",       3L, 3L));
		rule.add(new BbdcTypeCdr("RSP_CODE", ";",     4L, 4L));
		rule.add(new BbdcTypeCdr("RSP_DESC", ";",     5L, 5L));
		rule.add(new BbdcTypeCdr("CREATE_DATE", ";", -1L, 6L,"sysdate"));
		rule.add(new BbdcTypeCdr("FILE_NAME", ";",   -1L, 7L));
		
		HandleReturnPara hr = fbs.fileBodyHandle(fb, rule, fn);
		return hr;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
