package com.training.hystrixdemoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DemoController {

	@Autowired
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod = "myfallback",commandKey = "demohystrixcommand")
	@GetMapping("/hello")
	public String greetFromUser() {
		return rt.getForObject("http://localhost:8080/hello", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "myfallback",commandKey = "demohystrixcommand2")
	@GetMapping("/hello1")
	public String greetFromUser1() {
		return rt.getForObject("http://localhost:8080/hello", String.class);
	}
	
	
	public String myfallback() {
		return "<h1>Sorry at Present My Dev are Lazy please come after a decade !!!!!</h1>";
	}
	
	
}
