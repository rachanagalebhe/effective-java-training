package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		menuDrivenProgram();
	
	}

	private static void menuDrivenProgram() {
		
		BankAccount a1=new BankAccount(88, "Vivek","p@ss",20000,12);
		Input input=new Input();
		int accno = input.readInt("Enter account number\n");
		String password = input.readString("Enter password\n");
		Double balance = input.readDouble("Enter balance\n");
		a1.setName("Rachana");
		BankAccount.setInterestRate(10);
		a1(accno,a1.getName(),password,balance,BankAccount.getInterestRate());
		int choice=0;
	
		do {
			
			choice=input.readInt("1. Deposit\n2. Withdraw\n3.Credit Interst\n4.Show\n0.Exit\nChoose:");
			
			switch(choice) {
			case 1:
				//Input input1=new Input();
				
				int amt1 = input.readInt("amount to deposit?");
				a1.deposit(amt1, a1.getBalance());
				break;
				
			case 2:
				int amt=input.readInt("amount to withdraw?");

				a1.withdraw(a1.getPassword(), amt, a1.getBalance());
				break;
				
			case 3:
				a1.creditInterest(a1.getBalance());
				break;
				
			case 4:
				System.out.println("Account Number\t"+a1.getAccountNumber());
				System.out.println("Name\t"+a1.getName());
				System.out.println("Password\t"+a1.getPassword()); 
				System.out.println("Balance\t"+a1.getBalance());
				System.out.println("Interest Rate\t"+BankAccount.getInterestRate());
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Input.Retry");	
				
			}
			
			System.out.println("\n\n");
			
		}while(choice!=0);
	}

	private static void a1(int accno, String name, String password, Double balance, double interestRate) {
		// TODO Auto-generated method stub
		
	}

}
