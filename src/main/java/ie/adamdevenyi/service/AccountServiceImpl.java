package ie.adamdevenyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ie.adamdevenyi.dao.AccountDao;
import ie.adamdevenyi.domain.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDao accountDao;
	
	public void createAccount(int amount, int customerId) {
		
		accountDao.createAccount(amount);
		int accountId = accountDao.recentAccount();
		accountDao.addCustomerToAccount(customerId, accountId);
	}

	public void addCustomerToAccount(int customerId, int accountId) {
		
		accountDao.addCustomerToAccount(customerId, accountId);	
	}

	public List<Account> viewMyAccounts(int customerId) {

		return accountDao.viewMyAccounts(customerId);
	}

	public int getCurrentBalance(int accountId) {
		
		return accountDao.getCurrentBalance(accountId);
	}
	
	public void setBalance(int accountId, int amount) {
		
		accountDao.setBalance(accountId, amount);
	}

	public void deposite(int accountId, int amount) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(int sendAccountId, int getAccountId, int amount) {
		
		int sender = accountDao.getCurrentBalance(sendAccountId);
		accountDao.setBalance(sendAccountId, (sender - amount));
		int reciver = accountDao.getCurrentBalance(getAccountId);
		accountDao.setBalance(getAccountId, (reciver + amount));
		
		
	}

	public void closeAccount(int accountId) {
		
		accountDao.deleteConnection(accountId);
		accountDao.closeAccount(accountId);
		
	}

	public int recentAccount() {

		return accountDao.recentAccount();
	}

}
