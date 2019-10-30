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
		
		if ((!name.equals("")) && (name != null)  && (name.matches("^[a-zA-Z]*$"))) {
			customerDao.insertCustomer(name);
		}
		else {
			System.out.println("Wrong input! Please try again.\n");
		}
		
	}


	public Customer getCustomerByName(String name) {
		List<Customer> customers = customerDao.findAll();
		for(Customer customer : customers) {
			if (customer.getName().equals(name)){
				return customerDao.getCustomerByName(name);
			}
		}
		System.out.println("No customer found with this name! Please try again.\n");
		return null;
		
	}


	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

}
