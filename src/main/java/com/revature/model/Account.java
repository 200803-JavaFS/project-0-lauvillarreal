package com.revature.model;

import java.util.*;


public class Account {
	private String Name;
	private double checkingsBalance;
	private double savingsBalance;
	private List<String> transactionHistory;
	private UUID accountNumber;
	private boolean approval;
	
	
	
	public Account() {
		super();
	}

	
	public double getCheckingsBalance() {
		return checkingsBalance;
	}

	public void setCheckingsBalance(double checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	public UUID getId() {
		return accountNumber;
	}


	public void setId(UUID accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public boolean isStatus() {
		return approval;
	}


	public void setStatus(boolean status) {
		this.approval = status;
	}


	public List<String> getTransactionHistory() {
		return transactionHistory;
	}


	public void setTransactionHistory(List<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + (approval ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(checkingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionHistory == null) ? 0 : transactionHistory.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (approval != other.approval)
			return false;
		if (Double.doubleToLongBits(checkingsBalance) != Double.doubleToLongBits(other.checkingsBalance))
			return false;
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		if (transactionHistory == null) {
			if (other.transactionHistory != null)
				return false;
		} else if (!transactionHistory.equals(other.transactionHistory))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [Name=" + Name + ", checkingsBalance=" + checkingsBalance + ", savingsBalance=" + savingsBalance
				+ ", transactionHistory=" + transactionHistory + ", accountNumber=" + accountNumber + ", approval="
				+ approval + "]";
	}
	
	

}
