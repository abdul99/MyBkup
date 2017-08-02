package com.springprojects.boot.hateoas.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springprojects.boot.hateoas.model.Customer;

@Repository
public class CustomerRepository {

	private final List<Customer> customers = new ArrayList<>();

	public CustomerRepository() {
		this.customers.add(new Customer(1L, "Jack"));
		this.customers.add(new Customer(2L, "Adam"));
		this.customers.add(new Customer(3L, "Kim"));
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
