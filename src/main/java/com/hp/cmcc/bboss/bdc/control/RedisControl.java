package com.hp.cmcc.bboss.bdc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.cmcc.bboss.bdc.config.SpringUtil;
import com.hp.cmcc.bboss.bdc.pojo.User;
import com.hp.cmcc.bboss.bdc.utils.RedisUtil;


@RestController
public class RedisControl {

	@Autowired
	StringRedisTemplate redis;
	RedisUtil ru = SpringUtil.getBean(RedisUtil.class);
	@RequestMapping(value="/redis/get/{key}")
	public String redisTest(@PathVariable String key){
		return redis.opsForValue().get(key);
	}
	
	@RequestMapping(value="/test/obj/{name}")
	public User getObj(@PathVariable String name){
		User user = new User();
		user.setName(name);
		user.setGender("男");
		user.setAge(name.length()+20+"");;
		user.setHeight(name.length()+170+"cm");
		user.setWeight(name.length()+50+"kg");
		ru.set(name, user, 60);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (User) ru.get(name);
	}
}
