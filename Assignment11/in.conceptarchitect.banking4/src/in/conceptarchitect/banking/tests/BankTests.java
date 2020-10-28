package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;
import static in.conceptarchitect.utils.CustomAsserts.*;

public class BankTests {
	
	Bank bank=new Bank("ICICI", 10);
	
	int firstAccountNumber=0;
	int secondAccountNumber=0;
	
	BankAccount b1;
	String name1="Rachana";
	String correctPassword1="p@ss";
	double bal1=10000;
	
	BankAccount b2;
	String name2="Bhavana";
	String correctPassword2="p@ss";
	double bal2=15000;
	
	@Before  
	public void init() {		
		firstAccountNumber=bank.openAccount("savings",name1,correctPassword1, bal1);
		secondAccountNumber=bank.openAccount("savings",name2,correctPassword2, bal2);
	}
	
	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		int incorrectFromAccount = 6;
		double transferableAmount = 1700;
		boolean result=bank.transfer(incorrectFromAccount, transferableAmount, correctPassword1, secondAccountNumber); 		
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		int incorrectToAccount = 10;
		double transferableAmount = 1110;
		boolean result=bank.transfer(firstAccountNumber, transferableAmount, correctPassword1, incorrectToAccount); 	
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		double transferableAmount = 1500;
		String incorrectPassword = "wrong-P@ss";
		boolean result=bank.transfer(firstAccountNumber, transferableAmount, incorrectPassword, secondAccountNumber); 	
		assertTrue(result);
	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		double execedingAccountBalance = 43000;
		boolean result = bank.transfer(firstAccountNumber, execedingAccountBalance, correctPassword1, secondAccountNumber); 	
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result = bank.transfer(firstAccountNumber, 1330, correctPassword1, secondAccountNumber); 	
		assertTrue(result);
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		boolean result = bank.creditInterests(); 
		assertTrue(result);
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		int invalidAccountNumber = 15;
		boolean result = bank.close(invalidAccountNumber, correctPassword1);
		assertTrue(result);
	}
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		int closedAccountNumber = 15;
		double withdrawalAmount = 12000;
		boolean result = bank.withdraw(closedAccountNumber, withdrawalAmount, correctPassword1);
		assertFalse(result);
	}
	
	@Test
	public void openAccount_withSavingsTypeCreatesASavingAccount() {
		
		Bank bank=new Bank("bank name",1);
		
		bank.openAccount("savings", "someone", "somepassword", 1000);
		
		BankAccount account=bank.getAccount(1,"somepassword");
		
		assertType(SavingsAccount.class, account);
		
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		int firstAccount = bank.openAccount("savings","Vikas","p@ssword", bal1);
		int secondAccount = bank.openAccount("savings","Vivek","P@ssword", bal2);
		assertEquals(firstAccount, secondAccount,1);	
	}
	

}
