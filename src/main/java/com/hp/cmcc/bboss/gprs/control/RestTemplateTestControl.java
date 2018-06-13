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
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "150GB,851,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "162GB,751,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "36GB,451,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "64GB,241,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "17GB,751,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "23GB,451,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "34GB,011,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "56GB,234,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "170GB,543,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "120GB,123,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "110GB,567,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "10GB,234,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "50GB,456,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "100GB,097,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		fb.add("DONE,G03001120180606172722000000986,ADD,111800,上网行为管理AC-1000-A200-G1版一次性费用,业务模式,"
				+ "250GB,685,20180613095345,20990101010000,20180613095356,业务地域范围,统付时段");
		
		//测试配置
		List<BbdcTypeCdr> rule = new LinkedList<>(); 
		rule.add(new BbdcTypeCdr("err_code", ";",         0L, 3L, "String"));
		rule.add(new BbdcTypeCdr("proc_id", ";",          1L, 4L, "String"));
		rule.add(new BbdcTypeCdr("oper_type", ";",        2L, 5L, "String"));
		rule.add(new BbdcTypeCdr("service_id", ";",       3L, 6L, "String"));
		rule.add(new BbdcTypeCdr("app_name", ";",         4L, 7L, "String"));
		rule.add(new BbdcTypeCdr("service_type", ";",     5L, 8L, "String"));
		rule.add(new BbdcTypeCdr("nf_limit", ";",         6L, 9L, "String"));
		rule.add(new BbdcTypeCdr("valid_province", ";",   7L, 10L, "String"));
		rule.add(new BbdcTypeCdr("valid_date", ";",       8L, 11L, "String"));
		rule.add(new BbdcTypeCdr("expire_date", ";",      9L, 12L, "String"));
		rule.add(new BbdcTypeCdr("time_stamp", ";",       10L,13L, "String"));
		rule.add(new BbdcTypeCdr("service_range", ";",    11L,14L, "String"));
		rule.add(new BbdcTypeCdr("unified_period", ";",   12L,15L, "String"));
		rule.add(new BbdcTypeCdr("create_date", ";",     -1L, 16L, "String"));//
		rule.add(new BbdcTypeCdr("file_id", "/",         -1L, 18L, "String"));//
		rule.add(new BbdcTypeCdr("file_name", ";",       -1L, 17L, "String"));//
		rule.add(new BbdcTypeCdr("bdc_code", ";",        -1L, 0L, "String"));//
		rule.add(new BbdcTypeCdr("oper_serial_nbr", ";", -1L, 1L, "String"));//
		rule.add(new BbdcTypeCdr("record_hash", ";",     -1L, 2L, "String"));//
		
		//测试文件名
		String fn = "E_NFPAY_GPRS_FEE_20180503.020";
		//测试文件ID
		Integer fId = 555;
		
		GprsRecFilePara grfp = new GprsRecFilePara(fb, rule, fn, fId);
	    ResponseEntity<HandleReturnPara> responseEntity = rt.postForEntity(
	    		"http://GPRS-RECORD-SERVICE/record/addField", grfp, HandleReturnPara.class);
	    return responseEntity.getBody();
	}
}
