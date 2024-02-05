package com.in28minutes.springboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//it is a combination of @controller and @responsebody
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
//	@ResponseBody
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("hello world bean");
	}
	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldBean(@PathVariable String name,@PathVariable String message)
	{
		return new HelloWorldBean("hello world,"+name+" message "+message);
	}
}
