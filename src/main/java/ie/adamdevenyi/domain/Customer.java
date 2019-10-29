package ie.adamdevenyi.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {

	private int customerId;
	private String name;
	
	@Autowired
	public Customer() {

	}
	@Autowired
	public Customer(int customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}


	@Autowired
	public int getCustomerId() {
		return customerId;
	}


	@Autowired
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Autowired
	public String getName() {
		return name;
	}


	@Autowired
	public void setName(String name) {
		this.name = name;
	}


	@Autowired
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}
	
	
}
