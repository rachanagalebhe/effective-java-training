package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;

public class CurrentAccountTests {
	
	CurrentAccount currentAccount;
	String name = "Rachana";
	String correctPassword = "p@ss";
	double balance = 50000;
	
	@Before
	public void init() {
		currentAccount=new CurrentAccount(name,correctPassword, balance);
	}

	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {

		double amount=10000;
		CurrentAccount account=new CurrentAccount("","",amount);
		
		account.creditInterest(12);
		
		assertEquals(amount, account.getBalance(),0);  //balance shouldn't change after crediting interest 
				
	}

	
	@Test
	public void withdraw_canWithdrawUptoBalanceUsingRightPassword() {
		double withdrawalAmount = 3300;
		boolean result = currentAccount.withdraw(withdrawalAmount, correctPassword);
		assertFalse(result);
	}
	
	@Test
	public void withdraw_failsForInsufficientBalance() {
		double withdrawExecedingBalance = 80000;
		boolean result = currentAccount.withdraw(withdrawExecedingBalance, correctPassword);
		assertFalse(result);
	}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		double withdrawAmount = 10000;
		String incorrectPassword = "wrong-P@ass";
		boolean result = currentAccount.withdraw(withdrawAmount, incorrectPassword);
		assertFalse(result);
	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
		double withdrawNegativeAmount = -1111;		
		boolean result = currentAccount.withdraw(withdrawNegativeAmount, correctPassword);
		assertFalse(result);
	}
}
