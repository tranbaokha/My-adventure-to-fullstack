package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld{
	@RequestMapping(method = RequestMethod.GET, path = "hello-world")
	public String helloWorld() {
		return "Hello World Tran Bao Kha";
	}
	@RequestMapping(method = RequestMethod.GET, path = "hello-world-bean/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(name);
	}
}
