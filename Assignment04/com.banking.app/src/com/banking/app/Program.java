package com.banking.app;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
	
	BankAccount ba = new BankAccount(1403, "Rachana","hk200@",5000,6);
		
	int ch=0;
	Scanner sc = new Scanner(System.in);
	
	do {
		
		System.out.println("1.Deposit\n 2.Withdraw\n 3.Credit Interest\n 4.Show details\n 0.Quit");
		ch = sc.nextInt();
		
		switch(ch) {
		case 1:
			ba.deposit();
			break;
			
		case 2:
			ba.withdraw();
			break;
			
		case 3:
			ba.creditInterest();
			break;
			
		case 4:
			ba.details();
			break;
			
		case 0:
			break;
	
		default:
			System.out.println("Invalid");	
			
		}
		
		System.out.println("\n");
		
	}while(ch!=0);
	
	sc.close();
	
	}
}
