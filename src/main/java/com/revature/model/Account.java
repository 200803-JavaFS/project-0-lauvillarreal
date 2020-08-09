package com.revature.model;

import java.util.*;


public class Account {
	private String Name;
	private int checkingsBalance;
	private int savingsBalance;
	private List<String> transactionHistory;
	private UUID Id;
	private int deposit;
	private int widthdraw;
	private int transfer;
	
	
	public Account() {
		super();
	}

	
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


	public int getWidthdraw() {
		return widthdraw;
	}



	public void setTransfer(int transfer) {
		this.transfer = transfer;
	}




	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}


	public UUID getId() {
		return Id;
	}


	public void setId(UUID id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	

}
