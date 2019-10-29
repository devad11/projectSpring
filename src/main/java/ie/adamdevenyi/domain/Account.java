package ie.adamdevenyi.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Account {
	
	private int accountId;
	private int balance;
	
	@Autowired
	public Account() {
	}
	
	@Autowired
	public Account(int accountId, int balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	
	@Autowired
	public int getAccountId() {
		return accountId;
	}
	
	@Autowired
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Autowired
	public int getBalance() {
		return balance;
	}
	
	@Autowired
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}
	
	
	

}
