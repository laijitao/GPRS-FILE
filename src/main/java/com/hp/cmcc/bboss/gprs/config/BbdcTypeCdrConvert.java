package com.hp.cmcc.bboss.gprs.config;

import org.springframework.core.convert.converter.Converter;
import com.hp.cmcc.bboss.gprs.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.utils.JsonUtils;

public class BbdcTypeCdrConvert implements Converter<BbdcTypeCdr, String>{

	@Override
	public String convert(BbdcTypeCdr cdr) {
		JsonUtils ju = new JsonUtils();
		return ju.objToJson(cdr);
	}
	
}
