package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestApiController {
	
	@Value("${connectionStringValue}")
	private String connectionStringValue;
	@Autowired
	private Environment env;
	
	@GetMapping("/getValue")
	public String getValue() {
		return connectionStringValue;
	}
	
	@GetMapping("/getEnv")
	public String getEnv() {
		return env.getProperty("connectionStringEnv");
	}
}
