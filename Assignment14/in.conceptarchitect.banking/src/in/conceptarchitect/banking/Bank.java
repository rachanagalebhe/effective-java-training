package in.conceptarchitect.banking;

import java.util.ArrayList;

import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class Bank {
	
	int accountCount=0;   	
	String name;
	double interestRate;
	public final int MAX_ACCOUNTS=10; //PROBLEM: we can't have more than this much account
	
	//storage for BankAccounts
	ArrayList<BankAccount> accounts=new ArrayList<BankAccount>(); 
	
	public Bank(String name, double interstRate) {
	
		this.interestRate=10;
		this.name=name;
		
		
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getAccountCount() {
		return accountCount;
	}

	public String getName() {
		return name;
	}
	
	BankAccount ba;
	
	private BankAccount getAccountById(int accountNumber) throws InvalidAccountNumberException {
		int count= accounts.size();
		if(accountNumber<1 || accountNumber>accountCount)
			//return null; //no such account
			throw new InvalidAccountNumberException(accountNumber);
		
		for(int i=0;i<count;i++){ 
			if(accounts.get(i).getAccountNumber()==accountNumber)
			   ba=accounts.get(i); 
			}
		return ba;
	}
	
	
	public void deposit(int accountNumber, double amount) throws InvalidAccountNumberException, InvalidDenominationException {
		BankAccount account = getAccountById(accountNumber);
		account.deposit(amount);
	}
	
	
	public int openAccount(String accountType,String name, String password,  double amount) {
		
		BankAccount account=null;
		
		
		switch(accountType.toLowerCase()) {
		
			default: case "savings": account=new SavingsAccount(name,password,amount);break;
			case "current": account=new CurrentAccount(name,password,amount);break;
			//case "overdraft":account=new OverDraftAccount(name,password,amount); break;
		}
		
		
		
		//Bank should set the account Number which is accessible due to package scope
		account.accountNumber=++accountCount;
		
		//add the account to account list
		
		//account number x will be stored on location x
		//we will never use index 0 to store a account
		//accounts[account.accountNumber]=account;  //add all accounts to the same collection
		accounts.add(account);

		//return the account Number
		return account.accountNumber;
	}
	
	
	
	public void close(int accountNumber, String password) throws InvalidCredentialsException, InvalidAccountNumberException, InsufficientBalanceException {
        int count= accounts.size();

		BankAccount account = getAccountById(accountNumber);
		
		account.authenticate(password);
				
		
		if(account.getBalance()<0)
			throw new InsufficientBalanceException(accountNumber, -account.getBalance()," You need to clear the overdue to close your account");
		
		
		for (int i = 0; i < count; i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber)
            accounts.remove(accounts.get(i));
        }
	}
	
	
	
	public void withdraw(int accountNumber, double amount, String password) throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		BankAccount account = getAccountById(accountNumber);
		account.withdraw(amount, password); //may return success or falure
	}

	
	
	public void transfer(int sourceAccountNumber,  double amount, String password,int targetAccountNumber) throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		
		BankAccount target=getAccountById(targetAccountNumber);
		BankAccount src = getAccountById(sourceAccountNumber);
		
		src.withdraw(amount, password);
		target.deposit(amount);
		
	}

	public void printAccountList() {
		int count= accounts.size(); 

		System.out.println("Account\tBalance\tName");
		for(int i=1;i<=count;i++) {
			System.out.println( accounts.get(i)); 
		}
	}
	
	
	public void creditInterests() {

		System.out.println("Account\tBalance\tName");
		for(BankAccount account : accounts){ 
			account.creditInterest(interestRate); 
		} 
	}

	public String getAccountInfo(int accountNumber, String pin) throws InvalidAccountNumberException, InvalidCredentialsException {
		// TODO Auto-generated method stub
		BankAccount account= getAccountById(accountNumber);
		account.authenticate(pin);
		return account.toString();
		
	}

	public BankAccount getAccount(int accountNumber, String password) throws InvalidAccountNumberException, InvalidCredentialsException {
		// TODO Auto-generated method stub
		BankAccount account=getAccountById(accountNumber);
		account.authenticate(password);
		return account;
	}
	
	
}
