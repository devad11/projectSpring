package ie.adamdevenyi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ie.adamdevenyi.dao.AccountDao;
import ie.adamdevenyi.domain.Account;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDao accountDao;
	
	public void createAccount(int amount, int overdraft, int customerId) {
		
		accountDao.createAccount(amount, overdraft);
		int accountId = accountDao.recentAccount();
		accountDao.addCustomerToAccount(customerId, accountId);
	}

	public void addCustomerToAccount(int customerId, int accountId) {
		
		boolean accountCheck = accountCheck(accountId);
		if (accountCheck){
				accountDao.addCustomerToAccount(customerId, accountId);
		}
		else {
			System.out.println("No account found with this ID! Please try again.\n");
		}
		
	}
	
	public List<Account> ListAllAccounts(){
				
		return accountDao.ListAllAccounts();
	}

	public List<Account> viewMyAccounts(int customerId) {

		return accountDao.viewMyAccounts(customerId);
	}

	public int getCurrentBalance(int accountId) {
		
		boolean accountCheck = accountCheck(accountId);
		if (accountCheck){
			return accountDao.getCurrentBalance(accountId);
		}
		System.out.println("No account found with this ID! Please try again.\n");
		return -1;

		
	}
	
	public void setBalance(int accountId, int amount) {
		
		accountDao.setBalance(accountId, amount);
	}
	
	public void withdraw(int accountId, int amount) {
		int overdraft = 0;
		List<Account> accounts = accountDao.ListAllAccounts();
		List<Integer> accountIds = new ArrayList<Integer>();
		for(Account account : accounts) {
			accountIds.add(account.getAccountId());
			if (account.getAccountId() == accountId) {
					overdraft = account.getOverdraft();
			}
		}
		if (accountIds.contains(accountId)){
			int balance = accountDao.getCurrentBalance(accountId);
			int res = balance - amount;
			if (res >= (0 - overdraft)) {
				accountDao.setBalance(accountId, res);
			}
			else {
				System.out.println("Not enough money on account!\n");
			}
		}
		else {
			System.out.println("No account found with this ID! Please try again.\n");
		}		
	}

	public void deposite(int accountId, int amount) {
		
		boolean accountCheck = accountCheck(accountId);
		if (accountCheck){
			int balance = accountDao.getCurrentBalance(accountId);
			accountDao.setBalance(accountId, (amount + balance));
		}
		else {
			System.out.println("No account found with this ID! Please try again.\n");
		}
			
	}

	public void transfer(int sendAccountId, int getAccountId, int amount) {
		
		boolean accountCheckSend = accountCheck(sendAccountId);
		boolean accountCheckGet = accountCheck(getAccountId);		
		int overdraft = 0;
		
		if (accountCheckSend && accountCheckGet){
			
			List<Account> accounts = accountDao.ListAllAccounts();
			for(Account account : accounts) {
				if (account.getAccountId() == sendAccountId) {
						overdraft = account.getOverdraft();
				}
			}
			
			int sender = accountDao.getCurrentBalance(sendAccountId);
			if ((sender - amount) >= (0 - overdraft)) {
				accountDao.setBalance(sendAccountId, (sender - amount));
				int reciver = accountDao.getCurrentBalance(getAccountId);
				accountDao.setBalance(getAccountId, (reciver + amount));
			}
			else {
				System.out.println("Not enough money on account.\n");
			}
		}
		else {
			System.out.println("Wrong Account number! Please try again.\n");
		}
	
	}

	public void closeAccount(int accountId) {
		
		accountDao.deleteConnection(accountId);
		accountDao.closeAccount(accountId);
		
	}

	public int recentAccount() {

		return accountDao.recentAccount();
	}
	
	public int getTotalDeposite() {
		
		int total = 0;
		List<Account> accounts = accountDao.ListAllAccounts();
		for(Account account : accounts) {
			total += account.getBalance();
		}
		return total;
	}
	
	public List<Account> richAcounts() {

		int n = 10000;
		List<Account> richAccounts = new ArrayList<Account>();
		List<Account> accounts = accountDao.ListAllAccounts();
		for(Account account : accounts) {
			if (account.getBalance() > n) {
				richAccounts.add(account);
			}
		}
		return richAccounts;
	}
	
	public boolean accountCheck(int accountId) {
		
		List<Account> accounts = accountDao.ListAllAccounts();
		List<Integer> accountIds = new ArrayList<Integer>();
		for(Account account : accounts) {
			accountIds.add(account.getAccountId());
		}
		if (accountIds.contains(accountId)){
			return true;
		}
		return false;
		
	}
	

}
