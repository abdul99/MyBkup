package com.springprojects.boot.hateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.boot.hateoas.message.Request;
import com.springprojects.boot.hateoas.message.Response;
import com.springprojects.boot.hateoas.model.Customer;
import com.springprojects.boot.hateoas.model.Order;
import com.springprojects.boot.hateoas.repo.CustomerRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(path = "/{id}")
	public Customer getCustomerById(@PathVariable Long id) {

		return this.repository.findOne(id);
	}

	@RequestMapping(path = "/{id}/orders")
	public List<Order> getOrdersForCustomer(@PathVariable Long id) {

		return this.repository.findOne(id).getOrders();
	}

	@RequestMapping(value = "/postorder", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Request request) {

		Customer customer = this.repository.findOne(request.getCustomerId());
		customer.getOrders().add(new Order(request.getOrder()));
		
		Response response = new Response("Done", customer);

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
