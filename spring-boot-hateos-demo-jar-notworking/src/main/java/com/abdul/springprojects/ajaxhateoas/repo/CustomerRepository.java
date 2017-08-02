package com.abdul.springprojects.ajaxhateoas.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.abdul.springprojects.ajaxhateoas.model.Customer;

@Repository
public class CustomerRepository {

	private final List<Customer> customers = new ArrayList<Customer>();

	public CustomerRepository() {
		System.out.println("Adding data");
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
