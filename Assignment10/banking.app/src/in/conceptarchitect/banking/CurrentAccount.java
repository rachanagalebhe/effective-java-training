package in.conceptarchitect.banking;

public class CurrentAccount extends BankAccount{

	protected CurrentAccount(String name, String password, double amount, double rate) {
		super(name, password, amount, rate);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void openAccount(String name, String password, double amount) {
		BankAccount bankAccount = new BankAccount(name, password, amount, this.interestRate);
		bankAccount.accountNumber = ++accountCount;
		for (int i = 0; i < 10; i++) {
			if (bankAccountArr[i] == null) {
				bankAccountArr[i] = bankAccount;
				break;
			}
		}
		System.out.println("current Account opened successfully");
		System.out.println("Your account no is:" + bankAccount.accountNumber);

	}

	public String withdraw(int accNo, String pass, double amt) {
		String result = "";
		for (int i = 0; i < 10; i++) {
			BankAccount bankAccount = (BankAccount) bankAccountArr[i];
			if (bankAccount.getAccountNumber() == accNo) {
				result = bankAccount.withdraw((int) amt, pass);
				System.out.println("Withdraw successfully");
				break;
			}
		}
		return result;
	}
	
	@Override
	public boolean creditInterest(int accNo) {
		boolean result=false;
		System.out.println("current bank account doesn't provide credit interest");
		return result;

	}

}
