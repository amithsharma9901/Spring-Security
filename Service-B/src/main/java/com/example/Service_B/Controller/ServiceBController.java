package com.example.Service_B.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-b")
public class ServiceBController {
@GetMapping("/hello")
public String sayHello() {
	return "hello from service b";
}
}
