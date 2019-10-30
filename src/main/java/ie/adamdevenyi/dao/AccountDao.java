package ie.adamdevenyi.dao;

import java.util.List;

import ie.adamdevenyi.domain.Account;

public interface AccountDao {

	void createAccount(int amount, int overdraft);
	void addCustomerToAccount(int customerId, int accountId);
	List<Account> ListAllAccounts();
	List<Account> viewMyAccounts(int customerId);
	int getCurrentBalance(int accountId);
	void setBalance(int accountId, int amount);
	void deposite(int accountId, int amount);
	void transfer(int sendAccountId, int getAccountId, int amount);
	void deleteConnection(int accountId);
	void closeAccount(int accountId);
	int recentAccount();
}
