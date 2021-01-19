package com.webstoreapp.model.repository;

import java.util.List;

import com.webstoreapp.model.Customer;
import com.webstoreapp.model.Product;

public interface CustomerRepository {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();
}
