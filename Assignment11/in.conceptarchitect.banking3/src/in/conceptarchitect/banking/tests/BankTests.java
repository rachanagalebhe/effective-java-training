package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import org.junit.Before;


public class BankTests {
	Bank bank=new Bank("ICICI", 10);
	
	int firstAccountNumber, secondAccountNumber;
	
	BankAccount b1;
	String name1="Rachana";
	String correctPassword1="pass1";
	double bal1=10000;
	
	BankAccount b2;
	String name2="Bhavana";
	String correctPassword2="pass2";
	double bal2=30000;
	
	@Before  
	public void init() {		
		firstAccountNumber=bank.openAccount(name1,correctPassword1, bal1);
		secondAccountNumber=bank.openAccount(name2,correctPassword2, bal2);
	}
	
	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result=bank.transfer(firstAccountNumber, 1000, correctPassword1, 10); 		
		if(result) {
			fail("Target account number isn't present");
		}
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result=bank.transfer(firstAccountNumber, 1000, correctPassword1, 9); 	
		if(result) {
			fail("Target account number isn't present");
		}
		
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result=bank.transfer(firstAccountNumber, 1000, "wrong_p@ss", secondAccountNumber); 	
		if(result) {
			fail("Invalid password");
		}
		
}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result=bank.transfer(firstAccountNumber, 15000, "wrong_p@ass", secondAccountNumber); 	
		if(result) {
			fail("Balance is insufficient");
		}	
		}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result=bank.transfer(firstAccountNumber, 1000, correctPassword1, secondAccountNumber); 	
		if(result) {
			fail("Happy path");
		}
		
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		bank.creditInterests(); 	
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result=bank.close(9, correctPassword1);
		if(result) {
			fail("Passing invalid account no");
		}
		}
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result=bank.withdraw(10, 1000, correctPassword1);
		if(result) {
			fail("can't withdraw since account is closed");
		}
		}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		boolean result = bank.printAccountList();
		if(result) {
		fail("Accounts aren't created sequentialy");
		}
	}
	

}
