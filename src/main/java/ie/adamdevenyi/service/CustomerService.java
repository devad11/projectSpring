package ie.adamdevenyi.service;

import java.util.List;
import ie.adamdevenyi.domain.Customer;

public interface CustomerService {

	void insertCustomer(String name);
	Customer getCustomerByName(String name);
	List<Customer> findAll();
	
}
