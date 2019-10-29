package ie.adamdevenyi;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ie.adamdevenyi.domain.Customer;
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
            	String name;
            	System.out.println("Enter your name: ");
            	name = scan.next();
            	
            	CustomerService customerService = context.getBean(CustomerServiceImpl.class);
            	customerService.insertCustomer(name);
            	System.out.println("TEST: ");
            	Customer test = customerService.getCustomerByName(name);
            	System.out.println(test.toString());
            	System.out.println("\n");
            	
            	menu(context);
            	break;
            case 2:
            	
            	break;
            
            case 3:
            	
            	break;
            
            case 4:
            	
            	break;
            
            case 5:
            	
            	break;
            case 6:
            	
            	break;
            
            case 7:
            	
            	break;
            
            case 8:

            	break;
            	
            } // end of switch
        } while (choice != 9);
		
        scan.close();
	}

}
