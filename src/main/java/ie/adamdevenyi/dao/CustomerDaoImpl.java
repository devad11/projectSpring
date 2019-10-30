package ie.adamdevenyi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ie.adamdevenyi.domain.Customer;
import ie.adamdevenyi.mappers.CustomerRowMapper;


@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertCustomer(String name) {

		String sql = "INSERT INTO customer (name) VALUES (?)";
		jdbcTemplate.update(sql, name);
		
	}

	public Customer getCustomerByName(String name)
	{
		String sql = "SELECT * FROM customer WHERE customer.name = ?";
		Customer customer = 
		jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), name);
		return customer;
	}

	public List<Customer> findAll() {
		String sql = "SELECT * FROM customer";
		List<Customer> customers = 
		jdbcTemplate.query(sql, new CustomerRowMapper());
		return customers;
	}

}
