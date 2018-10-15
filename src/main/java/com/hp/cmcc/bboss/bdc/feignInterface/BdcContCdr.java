package com.hp.cmcc.bboss.bdc.feignInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hp.cmcc.bboss.bdc.pojo.BdcCompareResult;
import com.hp.cmcc.bboss.bdc.pojo.RequestParamter;

@FeignClient(value = "BDC-CONT-CDR")
public interface BdcContCdr {

	@RequestMapping(value = "/bdc/corpSMS/compare", method = RequestMethod.POST,consumes = "application/json")
	public BdcCompareResult threadHandle(@RequestBody RequestParamter requestParamter);

}
