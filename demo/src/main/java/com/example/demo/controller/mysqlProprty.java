package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mysql")
@PropertySource(value = "classpath:test.properties", ignoreResourceNotFound = true)
public class mysqlProprty {
	
	@Value("${mysql.jdbc.url}")
	private String url;
	
	@Value("${mysql.jdbc.name}")
	private String name;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
