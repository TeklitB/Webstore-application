package com.webstoreapp.service;

import java.util.List;

import com.webstoreapp.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> retrieveAllCustomers();
}
