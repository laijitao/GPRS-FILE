package com.hp.cmcc.bboss.bdc.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.cmcc.bboss.bdc.dao.BbdcTypeCdrDao;
import com.hp.cmcc.bboss.bdc.feignInterface.BdcContCdr;
import com.hp.cmcc.bboss.bdc.feignInterface.fileBodyService;
import com.hp.cmcc.bboss.bdc.pojo.BbdcTypeCdr;
import com.hp.cmcc.bboss.bdc.pojo.BdcCompareResult;
import com.hp.cmcc.bboss.bdc.pojo.RequestParamter;
import com.hp.cmcc.bboss.bdc.service.FileService;

@RestController
public class Control {
	@Autowired
	FileService fs;
	@Autowired
	fileBodyService fbs;
	@Autowired
	BdcContCdr bcc;
	@Autowired
	BbdcTypeCdrDao bbdcTypeCdrDao;
	
	
	@RequestMapping("/getcdr/")
	public List<BbdcTypeCdr> getCdrList() {
		return bbdcTypeCdrDao.findByValNameAndValType("D_5300_0632_GPRSAPNNI", "F_BODY");
	}
	
	@RequestMapping("/handle/{valName}")
	public BdcCompareResult fileThread(@PathVariable(value = "valName") String valName) {
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
		List<BbdcTypeCdr> rule = bbdcTypeCdrDao.findByValNameAndValType(valName, "F_BODY");
		
		String tranId = "TRAN_ID";
		RequestParamter requestParamter = new RequestParamter(fb, rule, fn,tranId );
		BdcCompareResult hr = bcc.threadHandle(requestParamter);
		return hr;
	}
	
	@RequestMapping("/file/test")
	public BdcCompareResult test() {
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
		List<BbdcTypeCdr> rule = bbdcTypeCdrDao.findByValNameAndValType("D_5300_0632_GPRSAPNNI", "F_BODY"); 
		String tranId = "TRAN_ID";
		RequestParamter requestParamter = new RequestParamter(fb, rule, fn,tranId );
		BdcCompareResult hr = bcc.threadHandle(requestParamter);
		return hr;
	}
	
}
