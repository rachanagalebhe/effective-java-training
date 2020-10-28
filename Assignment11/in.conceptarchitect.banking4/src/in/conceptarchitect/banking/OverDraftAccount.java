package in.conceptarchitect.banking;

public class OverDraftAccount extends BankAccount {

	public OverDraftAccount(String name, String password, double amount) {
		super(name, password, amount);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean withdraw(double amount, String password) {		
		if(amount>= getBalance()+getOdLimit())
			return false;		
		else
			return super.withdraw(amount, password); 
	}
	

	public double getOdLimit() {
		return getBalance()%10;
	}

}
