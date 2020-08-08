package com.revature.model;

import com.revature.main.Driver;

public class OpenAccount {
	int age;
	
	public OpenAccount() {
		super();
		System.out.println("To be eligible for a new account, you must be 18 years of age or older");
	}
	
	public boolean apply() {
		System.out.println("Please enter your age");
		age = Driver.scan.nextInt();
		if (age >= 18) {
			System.out.println("Congratulations " + RegisterUser.name + ", you are now able to use our banking system");
			return true;
			
		} else {
			System.out.println("We apologize, but we are not able to provide you with our banking system");
			System.out.println("You do not meet the age requirements");
			
			
			
		}return false;
	}
}
