package com.hp.cmcc.bboss.bdc.feignInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hp.cmcc.bboss.bdc.pojo.HandleReturnPara;
import com.hp.cmcc.bboss.bdc.pojo.RequestParamter;

@FeignClient(value = "BDC-CDR-SERVICE")
//@FeignClient(value = "ljt-record-SERVICE")
public interface fileBodyService {
	
	@RequestMapping(value = "/record/handle",method = RequestMethod.POST,consumes = "application/json")
	HandleReturnPara fileBodyThread(@RequestBody RequestParamter requestParamter);
	
}
