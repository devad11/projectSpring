package ie.adamdevenyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.adamdevenyi.dao.CustomerDao;
import ie.adamdevenyi.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	

	public void insertCustomer(String name) {
		customerDao.insertCustomer(name);
	}


	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByName(name);
	}


	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

}
