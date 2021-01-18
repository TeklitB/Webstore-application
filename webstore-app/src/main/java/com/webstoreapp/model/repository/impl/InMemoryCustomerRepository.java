package com.webstoreapp.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webstoreapp.model.Customer;
import com.webstoreapp.model.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customer = new ArrayList<Customer>();
		customer.add(new Customer("10001", "Adam", "Wall Street", 10));
		customer.add(new Customer("10002", "Smith", "New York", 5));
		return customer;
	}

}
