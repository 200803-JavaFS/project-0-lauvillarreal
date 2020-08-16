package com.revature.services;

import com.revature.utilities.*;

public class OpenAccount {
	private String name;
	int age;
	
	public OpenAccount() {
		super();
		
	}
	
	
	public OpenAccount(String name) {
		super();
		this.name = name;
		System.out.println("             To be eligible for a new account, you must be 18 years of age or older");
	}


	public boolean apply() {
		System.out.println("             Please enter your age");
		age = BankingApp.scan.nextInt();
		if (age >= 18) {
			System.out.println("             Congratulations " + name + ", you are now able to use our banking system!!");
			return true;
			
		} else {
			System.out.println("             We apologize, but we are not able to provide you with our banking system");
			System.out.println("             You do not meet the age requirements");
			
			
			
		}return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
