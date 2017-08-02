package com.javasampleapproach.angularhateoas.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Customer extends ResourceSupport {

	private Long customerId;
	private String name;

	private List<Order> orders;

	public Customer() {
	}

	public Customer(Long customerId, String name, ArrayList<Order> orders) {
		this.customerId = customerId;
		this.name = name;
		this.orders = new ArrayList<Order>(orders);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
