package com.revature.model;

import java.util.ArrayList;

public class Account {
	
	
	public Account() {
		super();
	}

	private int checkingsBalance;
	private int savingsBalance;
	private ArrayList<String> transactionHistory;

	
	public int getCheckingsBalance() {
		return checkingsBalance;
	}

	public void setCheckingsBalance(int checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}

	public int getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(int savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	

}
