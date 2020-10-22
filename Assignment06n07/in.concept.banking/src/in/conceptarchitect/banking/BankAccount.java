package in.conceptarchitect.banking;

import in.conceptarchitect.utils.Input;

public class BankAccount {
	
	int accountNumber;
	String name;
	String password;
	double balance;
	static double interestRate;
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	//you can't change your account number
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getPassword() {
		return password;
	}
	
	//balance
	public double getBalance() {
		return balance;
	}
	
	//no set balance. to set balance use deposit or withdraw
	
	//get set interest rate
	public static double getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(double interestRate) {
		BankAccount.interestRate = interestRate;
	}

	
	public  BankAccount(int accountNumber, String name, String password, double amount, double rate) {
		createAccount(accountNumber, name, password,amount, rate);
	}
	
	//I don't want anyone else calling this function
	private void createAccount(int accountNumber, String name, String password, double amount, double rate) {

		this.accountNumber=accountNumber;
		this.name=name;  //this.name is class field, name is argument
		this.password=password;
		
		this.balance=amount; //this is not required as balance has no conflict
		interestRate=rate;   //this is not required
	}

	
	public void deposit(int amount,double balance) {
		//TODO: write the deposit logic

		if(amount>0) {
			balance+=amount;
			System.out.println("Amount deposited successfully");
		}
		else {
			System.out.println("Invalid Amount. Deposit Failed");
		}
		
	}

	public void withdraw(String password, int amount, double balance) {
		// TODO Auto-generated method stub
	Input input=new Input();
		
		String pw=input.readString("password");
		
		if(!password.equals(pw)) {
			System.out.println("invalid credentials");
			return ;
		}else if(amount<=0) {
			
			System.out.println("invalid denomination. please enter positive amount");
			
		} else if(amount> balance) {
			
			System.out.println("Insufficient Funds");
			
		}else {
			
			balance-=amount;
			System.out.println("please collect your cash");
			
		}
		
	}

	public void creditInterest(double balance) {
		// TODO Auto-generated method stub
		balance+=(balance*interestRate)/1200; //one month interest at a time.
	}

}
