package com.hp.cmcc.bboss.gprs.control;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hp.cmcc.bboss.gprs.pojo1.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.pojo1.GprsRecFilePara;
import com.hp.cmcc.bboss.gprs.pojo1.HandleReturnPara;


@RestController
public class RestTemplateTestControl {
	
	@Autowired
	RestTemplate rt;
	
	@RequestMapping("/file/handleRecord")
	public HandleReturnPara fileHandle() {
		List<String> fb = new LinkedList<String>();
		//测试文件体
		fb.add("DONE,G03116,ADD,111800,上网行为,业务模式,"
				+ "150GB,851,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,1");
		fb.add("DONE,G03116,ADD,111894,上网行为,业务模式,"
				+ "162GB,751,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,2");
		fb.add("DONE,G03116,ADD,257894,上网行为,业务模式,"
				+ "36GB,451,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,3");
		fb.add("DONE,G03116,ADD,456127,上网行为,业务模式,"
				+ "64GB,241,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,4");
		fb.add("F001,G03116,ADD,784512,上网行为,业务模式,"
				+ "17GB,751,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,5");
		fb.add("DONE,G03116,ADD,635241,上网行为,业务模式,"
				+ "23GB,451,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,6");
		fb.add("DONE,G03116,ADD,897945,上网行为,业务模式,"
				+ "34GB,011,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,7");
		fb.add("DONE,G03116,ADD,589452,上网行为,业务模式,"
				+ "56GB,234,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,8");
		fb.add("F005,G03116,ADD,369571,上网行为,业务模式,"
				+ "170GB,543,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,9");
		fb.add("DONE,G03116,ADD,124678,上网行为,业务模式,"
				+ "120GB,123,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,10");
		fb.add("DONE,G03116,ADD,958415,上网行为,业务模式,"
				+ "110GB,567,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,11");
		fb.add("F007,G03116,ADD,361598,上网行为,业务模式,"
				+ "10GB,457,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,12");
		fb.add("DONE,G03116,ADD,849562,上网行为,业务模式,"
				+ "50GB,514,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,13");
		fb.add("F008,G03116,ADD,152418,上网行为,业务模式,"
				+ "100GB,874,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,14");
		fb.add("DONE,G03116,ADD,254987,上网行为,业务模式,"
				+ "250GB,456,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段,15");
		
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
		
		GprsRecFilePara grfp = new GprsRecFilePara(fb, rule, fn);
	    ResponseEntity<HandleReturnPara> responseEntity = rt.postForEntity(
	    		"http://BDC-CDR-SERVICE/record/addField", grfp, HandleReturnPara.class);
	    return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/file/test")
	@ResponseBody
	public String test() {
		return "connect to FILE-SERVICE";
	}
}
