package com.webstoreapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstoreapp.model.Customer;
import com.webstoreapp.model.repository.CustomerRepository;
import com.webstoreapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
