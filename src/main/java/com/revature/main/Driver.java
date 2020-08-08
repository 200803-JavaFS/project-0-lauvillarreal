package com.revature.main;

import java.util.Scanner;

import com.revature.model.LoginUser;
import com.revature.model.OpenAccount;
import com.revature.model.RegisterUser;

public class Driver {
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Introducing Velox Bank 
		System.out.println("Welcome to Velox Bank");
		System.out.println("Where Banking Is Made Simple");
		
	
		//Register User
		System.out.println("To open an account, register now.");
		RegisterUser user = new RegisterUser();
		
		
		//LogIn
		LoginUser loggedUser = new LoginUser(user.username, user.password);
		loggedUser.usernameVerification();
		
		//Verification
		if(loggedUser.passwordVerification()) {
			OpenAccount newAccount = new OpenAccount();
			newAccount.apply();
		}else {
			System.out.println("Authentification Failed! Start Over...");
		}
		
		
		
		
	}

}
