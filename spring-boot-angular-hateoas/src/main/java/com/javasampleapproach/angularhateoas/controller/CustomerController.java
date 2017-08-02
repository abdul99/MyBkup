package com.javasampleapproach.angularhateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.angularhateoas.message.Response;
import com.javasampleapproach.angularhateoas.model.Customer;
import com.javasampleapproach.angularhateoas.model.Order;
import com.javasampleapproach.angularhateoas.repo.CustomerRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(path = "/{id}")
	public Response getCustomerById(@PathVariable Long id) {

		Customer customer = this.repository.findOne(id);

		Response response = new Response("Done", customer);
		return response;
	}

	@RequestMapping(path = "/{id}/orders")
	public Response getOrdersForCustomer(@PathVariable Long id) {

		List<Order> orders = this.repository.findOne(id).getOrders();

		Response response = new Response("Done", orders);
		return response;
	}

	@RequestMapping(value = "/getcustomer/{id}", method = RequestMethod.GET)
	public Response getResource(@PathVariable Long id) {

		Customer customer = this.repository.findOne(id);

		customer.removeLinks();
		customer.add(linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel());
		customer.add(linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customer.getCustomerId()))
				.withRel("allOrders"));

		Response response = new Response("Done", customer);
		return response;
	}
}
