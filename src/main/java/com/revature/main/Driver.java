package com.revature.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menu.Logo;
import com.revature.menu.Menu;
import com.revature.services.LoginUser;
import com.revature.services.OpenAccount;
import com.revature.services.RegisterUser;

public class Driver {
	
	public static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(Driver.class); 
	
	public static void main(String[] args) {
		
		log.info("The application has started");
	
		//Logo
		Logo logo = new Logo();
		
		//Menu
		Menu m = new Menu();
		
	
		
		//Introducing Velox Bank 
		System.out.println("                                    Welcome to Velox Bank");
		System.out.println("                                  Where Banking Is Made Simple");
		
		addSpace();
		
		//Register User
		System.out.println("             To open an account, register now.");
		RegisterUser user = new RegisterUser();
		
		
		//LogIn
		LoginUser loggedUser = new LoginUser(user.username, user.password);
		loggedUser.usernameVerification();
		
		//Verification
		
		if(loggedUser.passwordVerification()) {
			OpenAccount newAccount = new OpenAccount();
			newAccount.apply();
		}else {
			System.out.println("                Authentification Failed! Start Over...");
		}
		
		log.info("The application is ending") ;
		
		
		
		
	}
	
	public static void addSpace() {
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		
		
	}
	

	public static void recur() {
		recur(); 
	} 
	

}
