package ie.adamdevenyi.dao;

import java.util.List;

import ie.adamdevenyi.domain.Customer;

public interface CustomerDao {
	
	void insertCustomer(String name);
	Customer getCustomerByName(String name);
	List<Customer> findAll();
	
}
