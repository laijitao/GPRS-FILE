package com.hp.cmcc.bboss.gprs.control;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hp.cmcc.bboss.gprs.feignInterface.TestInterface;
import com.hp.cmcc.bboss.gprs.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.pojo.GprsRecFilePara;
import com.hp.cmcc.bboss.gprs.pojo.HandleReturnPara;

@RestController
public class RestTemplateTestControl {
	
	@Autowired
	RestTemplate rt;
	@Autowired
	TestInterface ti;
	
	@RequestMapping("/file/handleRecord")
	public HandleReturnPara book3() {
		List<String> fb = new LinkedList<String>();
		//测试文件体
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,001,1,20180525");
		fb.add("DONE,G03001120180319172722000000986,MOD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,851,1,20180525");
		fb.add("DONE,G03001120180522172722000000986,DEL,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,871,1,20180525");
		fb.add("DONE,G03001120180408172722000000986,DEC,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,251,1,20180525");
		fb.add("DONE,G03001120180604172722000000986,ADD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,331,1,20180525");
		fb.add("DONE,G03001120180304172722000000986,MOD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,811,1,20180525");
		fb.add("DONE,G03001120180428172722000000986,ADD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,151,1,20180525");
		fb.add("DONE,G03001120180527172722000000986,DEC,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,111,1,20180525");
		fb.add("DONE,G03001120180515172722000000986,ADD,111800,1118000000059,上网行为管理AC-1000-A200-G1版一次性费用,"
				+ "上网行为管理AC-1000-A200-G1版一次性费用,20180323,29991231,20180321212347,100,1,20180525");
		
		//测试配置
		List<BbdcTypeCdr> rule = new LinkedList<>(); 
		rule.add(new BbdcTypeCdr("err_code", ";", 0, "String"));
		rule.add(new BbdcTypeCdr("oper_type", ";", 3, "String"));
		rule.add(new BbdcTypeCdr("unified_period", ";", 4, "String"));
		rule.add(new BbdcTypeCdr("service_id", ";", 7, "String"));
		rule.add(new BbdcTypeCdr("app_name", ";", 9, "String"));
		rule.add(new BbdcTypeCdr("nf_limit", ";", 11, "String"));
		rule.add(new BbdcTypeCdr("valid_province", ";", 18, "String"));
		rule.add(new BbdcTypeCdr("valid_date", ";", 30, "String"));
		rule.add(new BbdcTypeCdr("service_type", ";", 40, "String"));
		rule.add(new BbdcTypeCdr("expire_date", ";", 51, "String"));
		rule.add(new BbdcTypeCdr("time_stamp", ";", 59, "String"));
		rule.add(new BbdcTypeCdr("service_range", ";", 70, "String"));
		rule.add(new BbdcTypeCdr("bdc_code", ";", 75, "String"));
		rule.add(new BbdcTypeCdr("oper_serial_nbr", ";", 84, "String"));
		rule.add(new BbdcTypeCdr("record_hash", ";", 93, "String"));
		rule.add(new BbdcTypeCdr("proc_id", ";", 107, "String"));
		rule.add(new BbdcTypeCdr("create_date", ";", 015, "String"));
		rule.add(new BbdcTypeCdr("file_name", ";", 127, "String"));
		rule.add(new BbdcTypeCdr("file_name_id", ";", 138, "String"));
		
		//测试文件名
		String fn = "E_NFPAY_GPRS_FEE_20180503.020";
		//测试文件ID
		Integer fnId = 555;
		
		GprsRecFilePara grfp = new GprsRecFilePara(fb, rule, fn, fnId);
	    ResponseEntity<HandleReturnPara> responseEntity = rt.postForEntity(
	    		"http://gprs-record-service/record/addField", grfp, HandleReturnPara.class);
	    return responseEntity.getBody();
	}
}
