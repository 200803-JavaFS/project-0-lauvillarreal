package com.revature.services;

import java.util.InputMismatchException;

import com.revature.model.*;
import com.revature.utilities.*;


public class AccountServices {
	
	
	
	Account account = new Account();
	double checkingsBalance = account.getCheckingsBalance();
	double savingsBalance = account.getSavingsBalance();
	

	
	

	public void withdrawCheckings(){
		System.out.println("Enter widthrawal amount:");
		double amount = BankingApp.scan.nextInt();
		try {
			if (amount < 0) {
				System.out.println("Input can't be negative");
			}
			if (amount > checkingsBalance) {
				System.out.println("Not enough funds");
			} else {
				checkingsBalance -= amount;
				System.out.println("Withrawal complete!");
				System.out.println("Your checkings balance is now" + checkingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void withdrawSavings() {
		System.out.println("Enter widthrawal amount:");
		double amount = BankingApp.scan.nextInt();
		try {
			if (amount < 0) {
				System.out.println("Input can't be negative");
			}
			if (amount > savingsBalance) {
				System.out.println("Not enough funds");
			} else {
				savingsBalance -= amount;
				System.out.println("Withrawal complete!");
				System.out.println("Your checkings balance is now" + savingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void transfer(Account account) {
		
	}
	
	public void depositCheckings() {
		System.out.println("Enter deposit amount:");
		double amount = BankingApp.scan.nextInt();
		try {
			if (amount < 0) {
				System.out.println("Input can't be negative");
			
			} else {
				checkingsBalance += amount;
				System.out.println("Deposit complete!");
				System.out.println("Your checkings balance is now" + checkingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void deposiSavings() {
		System.out.println("Enter deposit amount:");
		double amount = BankingApp.scan.nextInt();
		try {
			if (amount < 0) {
				System.out.println("Input can't be negative");
			
			} else {
				savingsBalance += amount;
				System.out.println("Deposit complete!");
				System.out.println("Your savingss balance is now" + savingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	

}
