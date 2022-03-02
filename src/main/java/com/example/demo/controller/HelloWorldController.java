package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private final DummyService dummyService;

	@Autowired
	public HelloWorldController(DummyService d){
		dummyService = d;
	}

	@GetMapping("/hello")
	public String greeting() {
		return dummyService.callService("foo");
	}
}