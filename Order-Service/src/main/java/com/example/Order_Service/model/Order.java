package com.example.Order_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order_db`")
public class Order {
    @Id
    private int orderId;
    private int productId;
    private int quantity;
    private String status;
    
    
    
	public Order() {
		super();
	}
	public Order(int orderId, int productId, int quantity, String status) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}