package com.webstoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstoreapp.model.Customer;
import com.webstoreapp.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		return "addCustomer";
	}

	@RequestMapping(value = "/customers/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		customerService.addCustomer(newCustomer);
		return "redirect:/webstore/customers";
	}

	@RequestMapping("/customers")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.retrieveAllCustomers());
		return "customers";
	}
}
