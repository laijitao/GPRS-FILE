package com.hp.cmcc.bboss.gprs.control;

import java.io.IOException;
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
public class Control {
	@Autowired
	FileService fs;
	@Autowired
	fileBodyService fbs;

	@RequestMapping("/file/feignTest")
	public HandleReturnPara fileHandle() {
		String path = "D:\\test\\incoming\\";
		
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
		//GPRS_APNNI
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","APNNI_CODE", ";",       3L, 6L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","INDUSTRY_APP_TYPE", ";",4L, 7L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","CODE_PREFIX", ";",      5L, 8L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","ROAM_SETTLE_FLAG", ";", 6L, 9L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","VALID_DATE", ";",       7L, 10L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","EXPIRE_DATE", ";",      8L, 11L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","TIME_STAMP", ";",       9L, 12L));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","CREATE_DATE", ";",     -1L, 13L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","FILE_NAME", ";",       -1L, 14L));//
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","BDC_CODE", ";",        -1L, 0L,"011701"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","OPER_SERIAL_NBR", ";", -1L, 1L));//
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","RECORD_HASH", ";",     10L, 2L,"select OPER_SERIAL_NBR from import.bdc_gprs_011701_t where RECORD_HASH=?"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","BDC_ERR_CODE", ";",    -1L, 15L,"DONE","11"));
//		rule.add(new BbdcTypeCdr("E_GPRS_APNNI","LINE_NUM", ";",        -1L, 16L));//
		
		//定向流量
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","Err_CODE", ";",         0L, 3L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","PROC_id", ";",          1L, 4L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","OPER_TYPE", ";",        2L, 5L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","SERVICE_ID", ";",       3L, 6L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","APP_NAME", ";",         4L, 7L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","SERVICE_TYPE", ";",     5L, 8L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","NF_LIMIT", ";",         6L, 9L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","VALID_PROVINCE", ";",   7L, 10L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","VALID_DATE", ";",       8L, 11L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","EXPIRE_DATE", ";",      9L, 12L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","TIME_STAMP", ";",       10L,13L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","SERVICE_RANGE", ";",    11L,14L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","UNIFIED_PERIOD", ";",   12L,15L));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","CREATE_DATE", ";",     -1L, 16L,"sysdate"));//
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","FILE_NAME", ";",       -1L, 17L));//
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","BDC_CODE", ";",        -1L, 1L,"011701"));//
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","OPER_SERIAL_NBR", ";", -1L, 2L));//
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","RECORD_HASH", ";",     13L, 0L,"select OPER_SERIAL_NBR from bdc_gprs_011701_t where RECORD_HASH=?"));//
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","BDC_ERR_CODE", ";",    -1L, 18L,"DONE","14"));
		rule.add(new BbdcTypeCdr("E_NFPAY_GPRS_FEE","LINE_NUM", ";",        -1L, 19L));//
		
		//gprs业务计费代码
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","SERVICE_CODE", ";",     3L, 6L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","VALID_DATE", ";",       4L, 7L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","EXPIRE_DATE", ";",      5L, 8L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","DESCRIPTION", ";",      6L, 9L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","IS_CHARGE", ";",        7L, 10L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","FEE", ";",              8L, 11L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","TIME_STAMP", ";",       9L, 12L));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","CREATE_DATE", ";",     -1L, 13L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","FILE_NAME", ";",       -1L, 14L));//
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","BDC_CODE", ";",        -1L, 0L,"010201"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","OPER_SERIAL_NBR", ";", -1L, 1L));//
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","RECORD_HASH", ";",     10L, 2L,"select OPER_SERIAL_NBR from bboss.bdc_gprs_010201_t where RECORD_HASH=?"));//
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","BDC_ERR_CODE", ";",    -1L, 15L,"DONE","11"));
//		rule.add(new BbdcTypeCdr("E_GPRS_SERVICECODE","LINE_NUM", ";",        -1L, 16L));//
		
		//短信
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","ERR_CODE", ";",         0L, 3L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","PROC_ID", ";",          1L, 4L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","OPER_TYPE", ";",        2L, 5L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","SERV_TYPE", ";",        3L, 6L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","SERV_CODE", ";",        4L, 7L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","PROV_CODE", ";",        5L, 8L));//
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","SMS_TYPE", ";",         6L, 9L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","VALID_DATE", ";",       7L, 10L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","EXPIRE_DATE", ";",      8L, 11L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","PRODUCT_TYPE", ";",     9L, 12L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","PRODUCT_CODE", ";",     10L,13L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","ECID", ";",             11L,14L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","IS_BAL_PORT", ";",      12L,15L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","VALID_PROVINCE", ";",   13L,16L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","TIME_STAMP", ";",       14L,17L));
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","RECORD_HASH", ";",      15L, 2L,"select OPER_SERIAL_NBR from import.bdc_gprs_011701_t where RECORD_HASH=?"));//
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","CREATE_DATE", ";",     -1L, 18L,"sysdate"));//
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","FILE_NAME", ";",       -1L, 19L));//
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","BDC_CODE", ";",        -1L, 0L,"000231"));//
//		rule.add(new BbdcTypeCdr("E_CORP_SMS","OPER_SERIAL_NBR", ";", -1L, 1L));//
		
		//发布结果通知文件
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","PROC_ID", ";",      0L, 0L));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","STATUS", ";",       1L, 1L));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","REMARK", ";",       2L, 2L));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","CREATE_DATE", ";", -1L, 3L,"sysdate"));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","FILE_NAME", ";",   -1L, 4L));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","BDC_ERR_CODE", ";",-1L, 5L,"DONE","3"));
//		rule.add(new BbdcTypeCdr("NOTIFY_RESULT","LINE_NUM", ";",    -1L, 6L));
		
		//各省网元通知加载状态文件
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","PROC_ID", ";",      0L, 0L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","NODE_TYPE", ";",    1L, 1L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","PROVINCE_ID", ";",  2L, 2L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","STATUS", ";",       3L, 3L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","RSP_CODE", ";",     4L, 4L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","RSP_DESC", ";",     5L, 5L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","CREATE_DATE", ";", -1L, 6L,"sysdate"));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","FILE_NAME", ";",   -1L, 7L));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","BDC_ERR_CODE", ";",-1L, 8L,"DONE","6"));
//		rule.add(new BbdcTypeCdr("NOTIFY_INFO","LINE_NUM", ";",    -1L, 9L));
		
//		HandleReturnPara hr = fbs.fileBodyHandleTest(fb, rule, fn);
		HandleReturnPara hr = fbs.fileBodyHandle(fb, rule, fn);
		try {
			fs.writeFile(hr);
		} catch (IOException e) {
			System.out.println("响应结果打印异常！");
		}
		return hr;
		
	}
}
