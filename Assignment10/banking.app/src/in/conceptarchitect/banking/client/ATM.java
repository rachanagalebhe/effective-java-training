package in.conceptarchitect.banking.client;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.OverDraftAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.utils.Input;

public class ATM {
	
	public void start(){
		 Input input=new Input();	
		 SavingsAccount sa = new SavingsAccount();
		 OverDraftAccount oda = new OverDraftAccount();
		 CurrentAccount ca = new CurrentAccount();
		 int accountType = input.readInt("Select the type of bank account from below options\n1.Savings Bank Account\t2.Current Bank Account\t3.OverDraft Bank Account\n");
		 if(accountType == 1) {
			 operations(sa); 
		 } else if(accountType == 2) {
			 operations(ca);
		 } else {
			 operations(oda);
		 }
		 
	}
	
	private static void operations(Bank bank) {
		 Input input=new Input();	
		boolean quit=false;
		while (!quit) {				
			int choice = 0;
			int accountNo=0;
			int amt=0;
			choice = input.readInt(
					"1. Create Account\n2. Deposit\n3. Withdraw\n4. Show\n5. Change Password\n6. Credit interest\n7. Close account \n8. Exit\nChoose:\t");
			System.out.println("\n");
			switch(choice) {	
			case 1:
				String  name = input.readString("Please enter name");
				String  pass = input.readString("Please enter password");
				amt = input.readInt("Please enter amt");
				bank.openAccount(name, pass, amt);
				
				break;
			case 2:		
				accountNo=input.readInt("Please enter account Number");
				amt = input.readInt("Please enter amount");
				bank.deposit(accountNo, amt);
				break;
			case 3:
				accountNo = input.readInt("Please enter account number");
				amt= input.readInt("Please enter amount");
				String passwordToWithdraw= input.readString("Please enter password");
				bank.withdraw(accountNo, passwordToWithdraw, amt);
				break;
			case 4:
				accountNo = input.readInt("Please enter account number");
				bank.show(accountNo);
				break;
			case 5:
				accountNo = input.readInt("Please enter account number");
				String oldPassword= input.readString("Please enter old password");
				String newPassword= input.readString("Please enter new password");
				boolean b=bank.changePassword(accountNo,oldPassword, newPassword);
				if(b) {
					System.out.println("Password updated successfully");
				}else {
					System.out.println("Wrong old password");
				}
				break;
			case 6:		
				accountNo = input.readInt("Please enter account number");
				bank.creditInterest(accountNo);					
				break;
			case 7:		
				accountNo = input.readInt("Please enter account number to close");
				bank.closeAccount(accountNo);					
				break;
			case 8:
				quit = true;
				System.out.println("\nThank You");
				break;
			default:
				break;
			}
		}
	}
	
	
}
