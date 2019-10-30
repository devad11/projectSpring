package projectSpring;

import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ie.adamdevenyi.dao.AccountDao;
import ie.adamdevenyi.domain.Account;
import ie.adamdevenyi.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class AccountServiceImplTest {
	
	@Mock
	private AccountDao accountDao;
	
	private AccountServiceImpl service;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new AccountServiceImpl();
	}
	
	@Test
	void TestAccountCreated() {
		service.createAccount(100, 100, 2);		
		verify(accountDao).addCustomerToAccount(1, 2);
	}
	
	@Test
	void TestDeposite() {
		Account testAccount = new Account(12, 100, 20);
		service.deposite(12, 120);	
		verify((accountDao).getCurrentBalance(12) == 220);
	}
	
	@Test
	void TestTransfare() {
		Account testAccountOne = new Account(12, 100, 20);
		Account testAccountTwo = new Account(13, 100, 20);
		service.transfer(12, 13, 50);
		verify((accountDao).getCurrentBalance(12) == 50);
	}
	

}
