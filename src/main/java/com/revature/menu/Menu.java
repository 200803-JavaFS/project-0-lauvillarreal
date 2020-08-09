package com.revature.menu;

import java.util.*;

public class Menu {
	
	public static String checkingsBalance = "Checkings Balance";
	public static String savingsBalance = "Savings Balance";
	public static String makeDeposit = "Deposit";
	public static String makeWithdrawal = "Withdrawal";
	public static String makeTransfer = "Transfer";
	public static String openAccount = "Open New Account";
	
	
	

	public Menu() {
		super();
		System.out.println("____________________________________________________________________________________________________________________");
		displayMenu();
	}
	
	
	public static void displayMenu(){
		System.out.println("      [" + checkingsBalance + " (C)] [" + savingsBalance + " (S)] [" + makeDeposit + " (D)] [" + makeWithdrawal + " (W)] [" + makeTransfer + " (T)] [" + openAccount + " (O)]"  );
		
	}
	

}
