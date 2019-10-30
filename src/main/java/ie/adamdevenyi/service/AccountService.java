package ie.adamdevenyi.service;

import java.util.List;

import ie.adamdevenyi.domain.Account;

public interface AccountService {

	void createAccount(int amount, int overdraft, int customerId);
	void addCustomerToAccount(int customerId, int accountId);
	List<Account> ListAllAccounts();
	List<Account> viewMyAccounts(int customerId);
	int getCurrentBalance(int accountId);
	void setBalance(int accountId, int amount);
	void withdraw(int accountId, int amount);
	void deposite(int accountId, int amount);
	void transfer(int sendAccountId, int getAccountId, int amount);
	void closeAccount(int accountId);
	int recentAccount();
	int getTotalDeposite();
	List<Account> richAcounts();
	boolean accountCheck(int accountId);
}
