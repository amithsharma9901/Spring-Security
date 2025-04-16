package com.example.Service_A.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@FeignClient(name="Service-B")  //name of feignclient should match project name(another microservice)
public interface ServiceBClient {
@GetMapping("/service-b/hello")
@CircuitBreaker(name="serviceB",fallbackMethod="fallbackhello")
String getHelloFromServiceB();
default String fallbackhello(Throwable t) {
	return "Service B is down";
}
}
