package com.revature.model;



public class Account {
	private String Name;
	private double checkingsBalance;
	private double savingsBalance;
	private String username;
	private String status;
	
	
	
	public Account() {
		super();
	}
	
	public Account(String name, double checkingsBalance, double savingsBalance, String username, String status) {
		super();
		Name = name;
		this.checkingsBalance = checkingsBalance;
		this.savingsBalance = savingsBalance;
		this.username = username;
		this.status = status;
	}
	
	
	
	public Account(String name, double checkingsBalance, double savingsBalance, String status) {
		super();
		Name = name;
		this.checkingsBalance = checkingsBalance;
		this.savingsBalance = savingsBalance;
		this.status = status;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		long temp;
		temp = Double.doubleToLongBits(checkingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(checkingsBalance) != Double.doubleToLongBits(other.checkingsBalance))
			return false;
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [ Name = " + Name + ",   checkingsBalance = " + checkingsBalance + ",  savingsBalance = " + savingsBalance
				+ ",  accountID = " + username + ",  status = " + status + " ]";
	}


	

	
	




	
	

}
