package com.javasampleapproach.angularhateoas.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javasampleapproach.angularhateoas.model.Customer;
import com.javasampleapproach.angularhateoas.model.Order;

@Repository
public class CustomerRepository {

	private final List<Customer> customers = new ArrayList<>();

	public CustomerRepository() {
		this.customers.add(new Customer(1L, "Jack",
				new ArrayList<Order>(Arrays.asList(new Order(1L, "SmartPhone A"), new Order(2L, "Tablet B")))));
		this.customers.add(new Customer(2L, "Adam",
				new ArrayList<Order>(Arrays.asList(new Order(3L, "SmartPhone C"), new Order(4L, "Tablet D")))));
		this.customers.add(new Customer(3L, "Kim",
				new ArrayList<Order>(Arrays.asList(new Order(5L, "SmartPhone E"), new Order(6L, "Tablet F")))));
	}

	public List<Customer> findAll() {
		return this.customers;
	}

	public Customer findOne(Long id) {

		for (Customer customer : this.customers) {
			if (customer.getCustomerId().equals(id)) {
				return customer;
			}
		}
		return null;
	}
}
