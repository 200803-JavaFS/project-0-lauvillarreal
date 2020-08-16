package com.revature.services;

import java.util.*;

import com.revature.model.User;
import com.revature.utilities.BankingApp;


public class LoginUser extends User {
	static String username;
	static String password;
	static int count1;
	static int count2;
	
	public LoginUser() {
		super();
		
	}
	
	public LoginUser(String username, String password) {
		super();
		LoginUser.username = username;
		LoginUser.password = password;
		
		
	}
	public boolean usernameVerification() {
		System.out.println("             Log In by entering your account username");
		String userName = BankingApp.scan.nextLine();
		count1 = 4;
		while (count1 > 0) {
		if (username.equals(userName)) {

			return true;
		} else {
			System.out.println("               Username does not exists, try again");
			System.out.println("               Number of tries left: " + count1);
			userName = BankingApp.scan.nextLine();
			count1--;
			
		}
		
		}return false;
		
	}
	
	public static boolean passwordVerification() {
		System.out.println("             Enter password");
		String passWord = BankingApp.scan.nextLine();
		count2 = 4;
		while (count2 > 0) {
			if (password.equals(passWord)) {
				System.out.println("             Authentication Successful!");
				return true;
				
			} else {
				System.out.println("             Password did not match username, try again");
				System.out.println("             Number of tries left: " + count2);
				passWord = BankingApp.scan.nextLine();
				count2--;
				
			}
			}return false;
		
	}
	
	

}
