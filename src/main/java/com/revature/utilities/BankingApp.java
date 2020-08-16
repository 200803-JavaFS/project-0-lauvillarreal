package com.revature.utilities;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.*;
import com.revature.services.LoginUser;
import com.revature.services.OpenAccount;
import com.revature.services.RegisterUser;

public class BankingApp {
	
	public static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(BankingApp.class); 
	public static String checkingsBalance = "Checkings Balance";
	public static String savingsBalance = "Savings Balance";
	public static String makeDeposit = "Deposit";
	public static String makeWithdrawal = "Withdrawal";
	public static String makeTransfer = "Transfer";
	public static String openAccount = "Open New Account";

	
	public void application () {
		
		log.info("The application has started");
	
		//Logo
		logo();
		
		//Introducing Velox Bank 
		introduction();
		
		//Entrance Menu
		loginAndRegisterMenu();
		
		//Service Menu
		Menu();
		log.info("The application is ending") ;
	}
	
	public void logo(){
		Logo logo = new Logo();
	}
	
	
	public static void addSpace() {
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		
		
	}
	

	public void  Menu() {
		System.out.println("____________________________________________________________________________________________________________________");
		displayMenu();
	}
	
	
	public void displayMenu(){
		System.out.println("      [" + checkingsBalance + " (C)] [" + savingsBalance + " (S)] [" + makeDeposit + " (D)] [" + makeWithdrawal + " (W)] [" + makeTransfer + " (T)] [" + openAccount + " (O)]"  );
		addSpace();
	}
	
	public void introduction() {
		System.out.println("                                    Welcome to Velox Bank");
		System.out.println("                                  Where Banking Is Made Simple");
		addSpace();
	}
	
	public void register() {
		System.out.println("             To open an account, register now.");
		RegisterUser user = new RegisterUser();
	
	}
	
	public void login() {
		//if (Reg.getUsername() == null) {
			
		//}
		LoginUser loggedUser = new LoginUser();
		loggedUser.usernameVerification();
		if(LoginUser.passwordVerification()) {
			OpenAccount newAccount = new OpenAccount();
			newAccount.apply();
		}else {
			System.out.println("                Authentification Failed! Start Over...");
		}
	}
	
	public void loginAndRegisterMenu() {
		System.out.println("             What would you like to do?: \n"
				+ "\n"
				+ "             Login [login] \n"
				+ "             Register [register] \n"
				+ "             Exit [exit]");
		String answer = scan.nextLine(); 
		answerSwitch(answer);
	}

	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "login": 
				login();
				User.setLoggedIn(true);
				break;
			case "register":
				register();
				OpenAccount open = new OpenAccount();
				break;
			case "exit":
				System.out.println("Thank you for using the application. Hope to see you soon!");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again. ");
				loginAndRegisterMenu();
				break;
		}
	}
	

	

}
