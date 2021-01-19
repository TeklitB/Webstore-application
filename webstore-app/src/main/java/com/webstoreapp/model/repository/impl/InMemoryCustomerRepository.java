package com.webstoreapp.model.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webstoreapp.model.Customer;
import com.webstoreapp.model.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAllCustomers() {
//		List<Customer> customer = new ArrayList<Customer>();
//		customer.add(new Customer("10001", "Adam", "Wall Street", 10));
//		customer.add(new Customer("10002", "Smith", "New York", 5));
//		return customer;
		Map<String, Object> params = new HashMap<String, Object>();
		List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper());
		return result;
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("CUSTOMER_ID"));
			customer.setName(rs.getString("CUSTOMER_NAME"));
			customer.setAddress(rs.getString("CUSTOMER_ADDRESS"));
			customer.setNoOfOrdersMade(rs.getLong("NUMBER_OF_ORDERS_MADE"));
			return customer;
		}
	}

	@Override
	public void addCustomer(Customer customer) {

		String SQL = "INSERT INTO CUSTOMERS (CUSTOMER_ID, " + "CUSTOMER_NAME," + "CUSTOMER_ADDRESS,"
				+ "NUMBER_OF_ORDERS_MADE) " + "VALUES (:id, :name, :address, :noOfOrdersMade)";
		Map<String, Object> params = new HashMap<>();
		params.put("id", customer.getCustomerId());
		params.put("name", customer.getName());
		params.put("address", customer.getAddress());
		params.put("noOfOrdersMade", customer.getNoOfOrdersMade());
		jdbcTemplate.update(SQL, params);

	}

}
