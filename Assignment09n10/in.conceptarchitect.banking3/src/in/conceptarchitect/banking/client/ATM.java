package in.conceptarchitect.banking.client;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.utils.Input;

public class ATM {
	
	
	Bank bank ;
	Input keyboard=new Input();
	private int accountNumber;
	
	public void connectTo(Bank bank) {
		// TODO Auto-generated method stub
		this.bank=bank;
	}
	
	
	public void start() {
		
		displayWelcomeScreen();		
		
	}


	private void displayWelcomeScreen() {
		// TODO Auto-generated method stub
		while(true) {
			accountNumber=keyboard.readInt("accountNumber?");
			if(accountNumber==-999) {		//hidden admin menu
				if(keyboard.readString("error:").equals("NIMDA"))
					if(displayAdminMenu().equals("QUIT"))
						return;
			}else
				displayUserMenu();
		
		}
	}


	private void displayUserMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome "+accountNumber);
		
		int choice;
		do {
			choice=keyboard.readInt("1. Deposit  2. Widthraw  3. Transfer  4. Show 5. Close Account  0. Exit: ");
			switch(choice) {
			case 1:
				doDeposit(); break;
			case 2:
				doWithdraw(); break;
			case 3:
				doTransfer(); break;
			case 4:
				doShow(); break;
			case 5:
				doCloseAccount(); break;
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		
		
	}


	private void doCloseAccount() {
		// TODO Auto-generated method stub
		String ch=keyboard.readString("enter if u want to close account Y/N");
		if(ch=="Y") {
			bank.close(0, "Admin");
			System.out.println("Account closed");
			return;
		} else {
			System.out.println("Continue transaction");
		}
	}


	private void doShow() {
		// TODO Auto-generated method stub
		bank.printAccountList();
		
	}


	private void doTransfer() {
		// TODO Auto-generated method stub
		bank.transfer(0, 1000, "ADMIN" , 1);
	}


	private void doWithdraw() {
		// TODO Auto-generated method stub
		bank.withdraw(0, 1000, "ADMIN");

	}


	private void doDeposit() {
		// TODO Auto-generated method stub
		bank.deposit(0, 3000);

	}


	private String displayAdminMenu() {
		// TODO Auto-generated method stub
		int choice;
		do {
			choice=keyboard.readInt("1. Open Account  2. Credit Interest  3. Print Accounts  4. Shutdown  0. Exit: ");
			switch(choice) {
			case 1:
				doOpenAccount(); break;
			case 2:
				doCreditInterest(); break;
			case 3:
				doPrintAccounts(); break;
			case 4:
				return "QUIT";
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		return "";
	}


	private void doPrintAccounts() {
		// TODO Auto-generated method stub
		bank.printAccountList();
	}


	private void doCreditInterest() {
		// TODO Auto-generated method stub
		bank.creditInterests();

	}


	private void doOpenAccount() {
		// TODO Auto-generated method stub
		bank.openAccount("Rachana", "p@ass", 10000);

	}	
	
	
	
	
	
}
