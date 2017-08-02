package org.abdul.web.service;

import java.util.List;

import org.abdul.web.persistence.model.Customer;

public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}
