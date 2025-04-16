package com.example.Order_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Order_Service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}