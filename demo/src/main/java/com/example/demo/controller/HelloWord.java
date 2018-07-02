package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
	
	@Resource
	private mysqlProprty mysqlproperty;
	
	@Value("${mysql.jdbc.name}")
	private String  name;
	
	@RequestMapping("/helloworld")
	public String say() {
		
		
		return "name: "+name+"<br/> and property.name:"
				+ mysqlproperty.getName()
				+ "<br/>  and property.url:"+mysqlproperty.getUrl();
	}

}
