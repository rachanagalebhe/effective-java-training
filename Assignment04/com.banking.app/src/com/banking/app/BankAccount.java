package com.banking.app;

import java.util.Scanner;

public class BankAccount {
	
	int accountNumber;
	String name;
	String password;
	float balance;
	int interestRate;
	
	public int getAccountNumber() {
		return accountNumber;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public float getBalance() {
		return balance;
	}
	

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public BankAccount(int accountNumber, String name, String password, float amount, int rate) {

		this.accountNumber=accountNumber;
		this.name=name; 
		this.password=password;
		this.balance=amount; 
		this.interestRate=rate;   
	}
		
	public void deposit() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter amount to deposit");
		int amount=sc.nextInt();
		if(amount>0) {
			balance+=amount;
			System.out.println("Amount deposited!");
		}
		else {
			System.out.println("Invalid Amount. Deposit unsuccessful");
		}
		sc.close();
	}

	public void withdraw() {
				
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter amount to withdraw");
		int amount=sc.nextInt();
		System.out.println("Enter password");
		String password=sc.nextLine();
		
		if(!this.password.equals(password)) {
			
			System.out.println("invalid password");
		
		} else if(amount<=0) {
			
			System.out.println("invalid");
			
		} else if(amount> balance) {
			
			System.out.println("Insufficient balance");
			
		} else {
			
			balance-=amount;
			System.out.println("collect your amount");
			
		}
		sc.close();
	}

	public void creditInterest() {
		
		balance+=(balance*interestRate)/1200;
		
	}
	
	public void details() {
		System.out.println("Account Number\t"+this.accountNumber);
		System.out.println("Name\t"+name);
		System.out.println("Password\t"+password);
		System.out.println("Balance\t"+balance); 
		System.out.println("Interest Rate\t"+interestRate); 
	}
}
