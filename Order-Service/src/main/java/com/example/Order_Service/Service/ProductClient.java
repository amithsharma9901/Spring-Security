package com.example.Order_Service.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Product_Service.model.Product;

@FeignClient(name = "Product-Service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable int id);
}