package in.conceptarchitect.banking;

public class OverDraftAccount extends BankAccount{
	double odLimit;
	protected OverDraftAccount(String name, String password, double amount, double rate, double odLimit) {
		super(name, password, amount, rate);
		// TODO Auto-generated constructor stub
		this.odLimit=odLimit;
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
		System.out.println("overdraft Account opened successfully");
		System.out.println("Your account no is:" + bankAccount.accountNumber);

	}

	public String withdraw(int accNo, String pass, double amt) {
		String result = "";
		for (int i = 0; i < 10; i++) {
			BankAccount bankAccount = (BankAccount) bankAccountArr[i];
			if (bankAccount.getAccountNumber() == accNo) {
				if(amt<this.getBalance()-this.odLimit)
				result = bankAccount.withdraw((int) amt, pass);
				System.out.println("Withdraw successfully");
				break;
			}
		}
		return result;
	}
	public boolean creditInterest(int accNo) {
		boolean result=false;
		for (int i = 0; i < 10; i++) {
			BankAccount bankAccount = (BankAccount) bankAccountArr[i];
			if (bankAccount.getAccountNumber() == accNo) {
				bankAccount.creditInterest();
				System.out.println("Credit interested successfully" + bankAccount.balance);
				result= true;
				break;
			}
		}
		return result;

	}

}
