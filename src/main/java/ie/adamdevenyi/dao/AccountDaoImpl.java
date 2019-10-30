package ie.adamdevenyi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ie.adamdevenyi.domain.Account;
import ie.adamdevenyi.mappers.AccountRowMapper;


@Repository
public class AccountDaoImpl implements AccountDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void createAccount(int amount) {

		String sql = "INSERT INTO account (balance) VALUES (?)";
		jdbcTemplate.update(sql, amount);
		
	}

	public void addCustomerToAccount(int customerId, int accountId) {
		
		String sql = "INSERT INTO account_owners(accountId, customerId) VALUES (?, ?)";
		jdbcTemplate.update(sql, accountId, customerId);
		
	}

	public List<Account> viewMyAccounts(int customerId) {

		String sql = "SELECT * FROM account ac join account_owners ao on ac.accountId = ao.accountId WHERE ao.customerId = ?";
		List<Account> accounts = 
		jdbcTemplate.query(sql, new AccountRowMapper(), customerId);
		return accounts;
	}

	public int getCurrentBalance(int accountId) {

		String sql = "SELECT balance FROM account WHERE accountId = ?";
		int balance = 
		jdbcTemplate.queryForObject(sql, Integer.class, accountId);
		return balance;		
	}

	public void setBalance(int accountId, int amount) {

		String sql = "UPDATE account SET balance = ? WHERE accountId = ?";
		jdbcTemplate.update(sql, amount, accountId);

	}	
	
	public void deposite(int accountId, int amount) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(int sendAccountId, int getAccountId, int amount) {
		// TODO Auto-generated method stub
		
	}

	public void deleteConnection(int accountId) {
		
		String sql = "DELETE from account_owners WHERE accountId = ?";
		jdbcTemplate.update(sql, accountId);
	}
	
	public void closeAccount(int accountId) {
		
		String sql = "DELETE from account WHERE accountId = ?";
		jdbcTemplate.update(sql, accountId);
	}

	public int recentAccount() {
		String sql = "SELECT MAX(accountId) from account";
		int account = 
		jdbcTemplate.queryForObject(sql, Integer.class);
		return account;
	}

}
