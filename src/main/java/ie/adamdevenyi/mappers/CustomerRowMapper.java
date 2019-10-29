package ie.adamdevenyi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import ie.adamdevenyi.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>
{
	
	public Customer mapRow(ResultSet rs, int rowNumber)
	throws SQLException
	{
		Customer customer = new Customer();
		customer.setCustomerId(rs.getInt("customerId"));
		customer.setName(rs.getString("name"));
		return (Customer) customer;
	}

}
