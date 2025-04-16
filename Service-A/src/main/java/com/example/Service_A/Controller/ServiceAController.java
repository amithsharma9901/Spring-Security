package com.example.Service_A.Controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_A.Services.ServiceBClient;
 
@RestController
@RequestMapping("/service-a")
public class ServiceAController {
	@Autowired
	private ServiceBClient serviceBClient;
	@GetMapping("/call-service-b")
	public String callServiceB()
	{
		return serviceBClient.getHelloFromServiceB();
	}

 
}