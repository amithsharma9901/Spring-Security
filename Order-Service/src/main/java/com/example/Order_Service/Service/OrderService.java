package com.example.Order_Service.Service;

import org.springframework.stereotype.Service;

import com.example.Order_Service.model.Order;
import com.example.Order_Service.repository.OrderRepository;
import com.example.Product_Service.model.Product;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public Order placeOrder(Order order) {
        // Validate product availability through Feign Client
        Product product = productClient.getProductById(order.getProductId());
        if (product != null && product.getInventory() >= order.getQuantity()) {
            // Place order logic
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product unavailable or insufficient inventory.");
        }
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}