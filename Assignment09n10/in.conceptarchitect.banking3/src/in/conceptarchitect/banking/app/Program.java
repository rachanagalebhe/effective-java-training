package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.client.ATM;
import in.conceptarchitect.utils.Input;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank icici=new Bank("ICICI", 12); //bank will have bank accounts
		
		ATM atm=new ATM(); //should be connected to some bank
		
		atm.connectTo(icici); //assoicate the hardware with the Bank		
		
		atm.start();  //switch on the ATML machine
		
		

	}
}
