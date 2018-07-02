package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

import jodd.json.JsonSerializer;


@RestController
@RequestMapping("/ajax")
public class HelloAjax {
	
	@Resource
	private StringRedisTemplate redisClient;
	
	@Resource
	private UserService userService;

	@RequestMapping("/hello")
	public User name() {
		 String uuid="0f49445d-98c6-43a8-bf85-8af3e206711b";
		 User user=userService.findUserById(uuid);
		 String json = new JsonSerializer().exclude("bmDm")
			        .serialize(user);
		 System.out.println(2);
		 System.out.println(json);
		return userService.findUserById(uuid);
		
	}
	
	@RequestMapping("/helloRedis")
	public String fromRedis() {
		redisClient.opsForValue().set("newKey", "testRedis");
		String result= redisClient.opsForValue().get("test");
		return result;
	}
}
