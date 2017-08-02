package org.abdul.web.service;

import java.util.List;

import org.abdul.web.persistence.model.Order;

public interface OrderService {

    List<Order> getAllOrdersForCustomer(String customerId);

    Order getOrderByIdForCustomer(String customerId, String orderId);

}
