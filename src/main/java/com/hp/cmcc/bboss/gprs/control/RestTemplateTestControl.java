package com.hp.cmcc.bboss.gprs.control;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hp.cmcc.bboss.gprs.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.pojo.GprsRecFilePara;
import com.hp.cmcc.bboss.gprs.pojo.HandleReturnPara;

@RestController
public class RestTemplateTestControl {
	
	@Autowired
	RestTemplate rt;
	
	@RequestMapping("/file/handleRecord")
	public HandleReturnPara fileHandle() {
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
		rule.add(new BbdcTypeCdr("err_code", ";", 20, "String"));
		rule.add(new BbdcTypeCdr("file_name", ";", 167, "String"));//
		rule.add(new BbdcTypeCdr("oper_type", ";", 34, "String"));
		rule.add(new BbdcTypeCdr("unified_period", ";", 148, "String"));
		rule.add(new BbdcTypeCdr("service_id", ";", 47, "String"));
		rule.add(new BbdcTypeCdr("app_name", ";", 59, "String"));
		rule.add(new BbdcTypeCdr("expire_date", ";", 114, "String"));
		rule.add(new BbdcTypeCdr("file_id", "/", 189, "String"));//
		rule.add(new BbdcTypeCdr("valid_province", ";", 98, "String"));
		rule.add(new BbdcTypeCdr("valid_date", ";", 103, "String"));
		rule.add(new BbdcTypeCdr("service_type", ";", 67, "String"));
		rule.add(new BbdcTypeCdr("create_date", ";", 159, "String"));//
		rule.add(new BbdcTypeCdr("time_stamp", ";", 126, "String"));
		rule.add(new BbdcTypeCdr("nf_limit", ";", 78, "String"));
		rule.add(new BbdcTypeCdr("service_range", ";", 137, "String"));
		rule.add(new BbdcTypeCdr("proc_id", ";", 27, "String"));
		rule.add(new BbdcTypeCdr("bdc_code", ";", 0, "String"));//
		rule.add(new BbdcTypeCdr("oper_serial_nbr", ";", 6, "String"));
		rule.add(new BbdcTypeCdr("record_hash", ";", 13, "String"));//
		
		//测试文件名
		String fn = "E_NFPAY_GPRS_FEE_20180503.020";
		//测试文件ID
		Integer fnId = 555;
		
		GprsRecFilePara grfp = new GprsRecFilePara(fb, rule, fn, fnId);
	    ResponseEntity<HandleReturnPara> responseEntity = rt.postForEntity(
	    		"http://GPRS-RECORD-SERVICE/record/addField", grfp, HandleReturnPara.class);
	    return responseEntity.getBody();
	}
}
