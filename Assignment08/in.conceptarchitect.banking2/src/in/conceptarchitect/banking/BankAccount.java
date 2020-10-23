package in.conceptarchitect.banking;

import in.conceptarchitect.utils.Input;

public class BankAccount {
	
	
	int accountNumber;
	String name;
	String password;
	double balance;
	
	static int accountCount=0;   //initalized with a constant	
	
	static double interestRate; //what is this value is pulled from a database and not a constant
	
	static {
		
		//write one-time initialization logic to initalize your static data
		//it is called before any constructor is called and as soon as class is loaded in the memory
		
		System.out.println("BankAccount intialized...");
		interestRate=10;
		
		//accountNumber=5;  //can't initalize non-static fields
		
	}
	
	public  BankAccount( String name, String password, double amount) {
		
		this.accountNumber= ++accountCount; //uses shared field to auto increment account number
		this.name=name;  
		this.password=salt(password); //we are saving a hashed/salted password and not the original one		
		
		this.balance=amount; 
		//interestRate=rate;   //static memebers are not initalized in constructor   
	}
	
	

	//Its a dummy and non-secured logic for password hashing just to demonstrated
	//the idea. Search for password hashing algorithm for better logic
	private String salt(String password) {
		String s="";
		for(int i=0;i<password.length();i++) {
			char ch=password.charAt(i);
			int v=Character.getNumericValue(ch);
			
			s+= Integer.toHexString(v);
		}
		return s;
	}
	
	public boolean authenticate(String password) {
		return salt(password).equals(this.password);
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		
		if(authenticate(oldPassword)) {
			password=salt(newPassword);
			return true;
		}else
			return false;
		
	}
	
	
	

	//not desirable and it is a security breach
	//	public String getPassword() {
	//		return password;
	//	}
	//
	//	public void setPassword(String password) {
	//		this.password = password;
	//	}
	
	
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

	
	
	
	
	
	public void show() {
		System.out.println("Account Number\t"+this.accountNumber); 
		System.out.println("Name\t"+name); 
		//System.out.println("Password\t"+password); 
		System.out.println("Balance\t"+balance); 
		System.out.println("Interest Rate\t"+interestRate); 
	}
	
	public boolean deposit(double amount) {
		//TODO: write the deposit logic
		
		if(amount>0) {
			balance+=amount;
			return true;	//System.out.println("Amount deposited successfully");
		}
		else {
			return false;//System.out.println("Invalid Amount. Deposit Failed");
		}
		
	}

	public boolean withdraw(double amount, String password) {
		// TODO Auto-generated method stub
		
		if(!authenticate(password)) {
			
			return false;
		}else if(amount<=0) {
			
			return false;
			
		} else if(amount> balance) {
			
			return false;
			
		}else {
			
			balance-=amount;
			return true;
			
		}
		
	}

	public void creditInterest() {
		// TODO Auto-generated method stub
		balance+=(balance*interestRate)/1200; //one month interest at a time.
	}
	
	
	public static boolean transfer(BankAccount source,  double amount, String password,BankAccount target) {
		
		if(source.withdraw(amount,password)) {
			target.balance+=amount;
			return true;
		} else {
			return false;
		}
		
		
	}

}
