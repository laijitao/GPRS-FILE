package com.hp.cmcc.bboss.bdc.feignInterface;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hp.cmcc.bboss.bdc.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.bdc.pojo.HandleReturnPara;
import com.hp.cmcc.bboss.bdc.pojo.User;

//@FeignClient(value = "BDC-CDR-SERVICE")
@FeignClient(value = "ljt-record-SERVICE")
public interface fileBodyService {

	@RequestMapping(value = "/record/addField",method = RequestMethod.POST,consumes = "application/json")
	HandleReturnPara fileBodyHandle(@RequestParam("fileBody") List<String> fileBody,  @RequestBody List<BbdcTypeCdr> rule, 
			@RequestParam("fileName") String fileName);
	
	
//	@RequestMapping(value = "/test",method = RequestMethod.POST,consumes = "application/json")
//	List<String> test(@RequestBody List<User> fileBody,@RequestParam("name") String name
//			,@RequestParam("ct") Date ct);
//	
//	@RequestMapping(value = "/testSql", method = RequestMethod.POST,consumes = "application/json")
//	public String testSql(@RequestParam("sql") String sql);


	
}
