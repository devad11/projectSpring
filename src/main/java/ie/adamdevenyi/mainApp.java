package ie.adamdevenyi;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ie.adamdevenyi.domain.Account;
import ie.adamdevenyi.domain.Customer;
import ie.adamdevenyi.service.AccountService;
import ie.adamdevenyi.service.AccountServiceImpl;
import ie.adamdevenyi.service.CustomerService;
import ie.adamdevenyi.service.CustomerServiceImpl;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext  context= new AnnotationConfigApplicationContext (BeanConfig.class);
		
		menu(context);
		
		context.close();
	}
	
	public static void menu(AnnotationConfigApplicationContext  context) {
		
    	String name;
    	Customer customer;
    	int customerId;
    	int accountId;
    	List<Account> myAccounts;
    	CustomerService customerService = context.getBean(CustomerServiceImpl.class);
    	AccountService accountService = context.getBean(AccountServiceImpl.class);
		
		System.out.println("1: become a bank customer\r\n" + 
				"2: create a new account\r\n" + 
				"3: add a person to an account\r\n" + 
				"4: view his/her own accounts\r\n" + 
				"5: withdraw money from his/her account (subject to an overdraft limit)\r\n" + 
				"6: deposit money into his/her account\r\n" + 
				"7: transfer money from one account to another\r\n" + 
				"8: close an account\r\n" +
				"9: Quit" );
		System.out.println("Press number for option: ");
		
		int choice;
        Scanner scan = new Scanner(System.in);
        do {
            choice = scan.nextInt();
            switch (choice) {
            case 1:
            	System.out.println("Enter your name: ");
            	name = scan.next();
            	customerService.insertCustomer(name);
          
            	menu(context);
            	break;
            case 2:

            	System.out.println("Enter your name: ");
            	name = scan.next();
            	System.out.println("Enter amount: ");
            	int amount = scan.nextInt();
            	
            	customer = customerService.getCustomerByName(name);
            	customerId = customer.getCustomerId();
            	accountService.createAccount(amount, customerId);
            	
            	myAccounts = accountService.viewMyAccounts(customerId);
            	System.out.println("Your accounts: ");
            	System.out.println(myAccounts.toString() + "\n");
            	
            	menu(context);
            	break;
            
            case 3:
            	System.out.println("Enter your name: ");
            	name = scan.next();
            	System.out.println("Enter account id: ");
            	accountId = scan.nextInt();
            	customer = customerService.getCustomerByName(name);
            	customerId = customer.getCustomerId();
            	
            	accountService.addCustomerToAccount(customerId, accountId);
            	
            	menu(context);
            	break;
            
            case 4:
            	System.out.println("Enter your name: ");
            	name = scan.next();
            	customer = customerService.getCustomerByName(name);
            	customerId = customer.getCustomerId();
            	myAccounts = accountService.viewMyAccounts(customerId);
            	System.out.println(myAccounts.toString());
            	
            	menu(context);
            	break;
            
            case 5:
            	System.out.println("Enter account id: ");
            	accountId = scan.nextInt();
            	int balance = accountService.getCurrentBalance(accountId);
            	System.out.println("Your balance is: " + balance);
            	System.out.println("Enter amount to withdraw: ");
            	int withdraw = scan.nextInt();
            	int newBalance = balance - withdraw;
            	accountService.setBalance(accountId, newBalance);
            	balance = accountService.getCurrentBalance(accountId);
            	System.out.println("Your balance is: " + balance);
            	
            	menu(context);
            	break;
            case 6:
            	System.out.println("Enter account id: ");
            	accountId = scan.nextInt();
            	int balanceAdd = accountService.getCurrentBalance(accountId);
            	System.out.println("Your balance is: " + balanceAdd);
            	System.out.println("Enter amount to deposite: ");
            	int deposite = scan.nextInt();
            	int nBalance = balanceAdd + deposite;
            	accountService.setBalance(accountId, nBalance);
            	balanceAdd = accountService.getCurrentBalance(accountId);
            	System.out.println("Your balance is: " + balanceAdd);
            	
            	menu(context);      
            	break;
            
            case 7:
            	System.out.println("Enter sender account id: ");
            	int sendAccountId = scan.nextInt();
            	System.out.println("Enter reciever account id: ");
            	int recAccountId = scan.nextInt();
            	System.out.println("Enter amount to deposite: ");
            	int transfAmount = scan.nextInt();
            	
            	accountService.transfer(sendAccountId, recAccountId, transfAmount);
            	
            	balance = accountService.getCurrentBalance(sendAccountId);
            	System.out.println("Your balance is: " + balance);
            	
            	balance = accountService.getCurrentBalance(recAccountId);
            	System.out.println("Your balance is: " + balance);
            	
            	menu(context);
            	break;
            
            case 8:
            	System.out.println("Enter account id: ");
            	accountId = scan.nextInt();
            	accountService.closeAccount(accountId);
            	
            	menu(context);
            	break;
            	
            } // end of switch
        } while (choice != 9);
		
        scan.close();
	}

}
