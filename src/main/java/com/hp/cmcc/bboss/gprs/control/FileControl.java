package com.hp.cmcc.bboss.gprs.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hp.cmcc.bboss.gprs.feignInterface.TestInterface;
import com.hp.cmcc.bboss.gprs.pojo1.BbdcTypeCdr;
import com.hp.cmcc.bboss.gprs.utils.JsonUtils;

@RestController
public class FileControl {
	
	@Autowired
	RestTemplate rt;
	@Autowired
	TestInterface ti;
	
	@RequestMapping(value = "gprs")
	@ResponseBody
	public List<String> handleFileBody() {
//		String fb = rt.getForObject("http://bdc-gprs-record-service/record",String.class);
		List<String> list = new LinkedList<String>();
		for(int i = 0; i < 10;i++) {
			list.add(i+"");
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "gprs-file")
	@ResponseBody
	public List<String> test() {
		List<String> fb = (List<String>)rt.getForObject("http://bdc-gprs-record-service/record",List.class);
		return fb;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getTest")
	@ResponseBody
	public List<String> hi() {
		JsonUtils ju = new JsonUtils();
		Map<Integer,String> map = new HashMap<>();
		for(int i = 0;i < 10;i++) {
			map.put(i, i*10000+1+"");
		}
		String str = ju.objToJson(map);
		String rs = rt.getForObject("http://TEST-SERVICE/hi?map={map}", String.class,str);
		return (List<String>) ju.JsonToObj(rs, List.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/mapTest")
	@ResponseBody
	public List<String> mapTest(@RequestBody Map<String,Object> values, HttpServletRequest request,HttpServletResponse response) {
		JsonUtils ju = new JsonUtils();
		Map<Integer,String> map = new HashMap<>();
		for(int i = 0;i < 10;i++) {
			map.put(i, i*10000+1+"");
		}
		request.setAttribute("map", map);
		String str = ju.objToJson(map);
		return (List<String>)rt.postForObject("http://TEST-SERVICE/mapTest?map={1}",str,List.class);
	}
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	@ResponseBody
    public String sayHi(){
		Map<Integer,String> map = new HashMap<>();
		for(int i = 0;i < 10;i++) {
			map.put(i, i*10000+1+"");
		}
        return ti.sayHiFromClientOne(map);
    }

}
