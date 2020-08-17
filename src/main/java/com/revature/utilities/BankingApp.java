package com.revature.utilities;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.AdminDAO;
import com.revature.DAO.EmployeesDAO;

import com.revature.model.*;
import com.revature.services.AccountServices;


public class BankingApp {
	
	public static final Scanner scan = new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(BankingApp.class); 
	private AccountServices as = new AccountServices();
	private EmployeesDAO ed = new EmployeesDAO(); 
	private AdminDAO ad = new AdminDAO();
	static User user = new User();
	static int count1;
	static int count2;
	Account account = user.getAccount();

	
	public void application () {
		
		log.info("The application has started");
	
		//Logo
		logo();
		
		//Introducing Velox Bank 
		introduction();

		
		//Logging In/Registering Menu
		loginAndRegisterMenu();
		
		
		//If user exits in database, then they can use application
		if (user != null) {
		serviceMenu();
		}
		
		
		
		log.info("The application is ending") ;
	}
	
	
	
	
	
	public void logo(){
		Logo logo = new Logo();
	}
	
	public void serviceMenu() {
		System.out.println("             Select one of the following options.");
		System.out.println("____________________________________________________________________________________________________________________");
		String checkingsBalance = "Checkings Balance";
		String savingsBalance = "Savings Balance";
		String makeDeposit = "Deposit";
		String makeWithdrawal = "Withdrawal";
		String makeTransfer = "Transfer";
		String openAccount = "Open New Account";
		System.out.println("     [" + checkingsBalance + " (C)] [" + savingsBalance + " (S)] [" + makeDeposit + " (D)] [" + makeWithdrawal + " (W)] [" + makeTransfer + " (T)] [Exit (E)]"  );
		System.out.println("____________________________________________________________________________________________________________________");
		addSpace();
		String answer = scan.nextLine().toLowerCase(); 
		answerSwitch1(answer);
		
	}
	
	private void answerSwitch1(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "c":
				account = ed.getAccountByUsername(user.getUsername());
				Double checkings_bal = account.getCheckingsBalance();
				System.out.println("            Your checkings has a balance of: " + checkings_bal);
				addSpace();
				serviceMenu();
				addSpace();
				break;
			case "s":
				Double savings_bal = account.getSavingsBalance();
				System.out.println("            Your savings has a balance of: " + savings_bal);
				addSpace();
				serviceMenu();
				addSpace();
				
				break;
			case "d":
				//getOneAvenger();
				break;
			case "w":
				//addAvenger();
				break;
			case "t":
				//addAvenger();
				break;
			case "e":
				System.out.println("             Thank you for using the application. Hope to see you soon!");
				addSpace();
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again. ");
				serviceMenu();
				break;
		}
	}

	public void introduction() {
		System.out.println("                                    Welcome to Velox Bank");
		System.out.println("                                  Where Banking Is Made Simple");
		addSpace();
	}

	
	public void login() {
		if(usernameVerification() && passwordVerification()) {
			System.out.println("             You are now logged in.");
			addSpace();
		}else {
			System.out.println("             Authentification Failed! Goodbye...");
		}
	}
	
	public String loginAndRegisterMenu() {
		System.out.println("             What would you like to do?: \n"
				+ "\n"
				+ "             Login [login] \n"
				+ "             Register [register] \n"
				+ "             Exit [exit]");
		String answer = scan.nextLine().toLowerCase(); 
		answerSwitch(answer);
		return answer;
	}

	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "login": 
				login();
				User.setLoggedIn(true);
				break;
			case "register":
				RegisterUser();
				User.setLoggedIn(true);
				break;
			case "exit":
				System.out.println("             Thank you for using the application. Hope to see you soon!");
				addSpace();
				break;
				
			default:
				System.out.println("             You have entered an incorrect value. Please try again. ");
				loginAndRegisterMenu();
				break;
		}
	}
	
	public void RegisterUser()  {
		System.out.println("             To open an account, register now.");

		
		//Name
		System.out.println("             Enter your first and last name");
		String Name = BankingApp.scan.nextLine();
	
		
		//Username
		System.out.println("             Enter a username");
		String username = BankingApp.scan.nextLine();
		
		
		//Password
		System.out.println("             Enter a password");
		String password = BankingApp.scan.nextLine();
		
		
		//Name
		System.out.println("             Are you a new [customer] [admin] [employee] ? ");
		String type = BankingApp.scan.nextLine();
		
		//Add account when registering
		System.out.println("             Thank you " + Name + " for registering with Velox Bank!");
		User user = new User(username, password, Name, true, type);
		addAccount(user);
		as.registerUser(user);
	
		
		//LogIn
		addSpace();
		System.out.println("             Select one of the following options. To exit, press exit.");
		
	}
	
	public boolean applyAccount(User user) {
		int age;
		System.out.println("             To be eligible for a new account, you must be 18 years of age or older");
		System.out.println("             Please enter your age");
		age = BankingApp.scan.nextInt();
		if (age >= 18) {
			System.out.println("             Congratulations " + user.getName() + ", you are now able to use our banking system!!");
			//UserDAO.addAccount()
			return true;
			
		} else {
			System.out.println("             We apologize, but we are not able to provide you with our banking system");
			System.out.println("             You do not meet the age requirements");
			
			
			
		}return false;
	}
	
	private Account addAccount(User user) {
		System.out.println("             What amount would you like to add to your checkings account?");
		int checkings_bal = scan.nextInt();
		scan.nextLine();
		System.out.println("             Would you like to open a savings account [yes] [no] ?");
		String openSavings = scan.nextLine();
		int savings_bal = 0;
		if (openSavings.equals("yes")) {
			System.out.println("             What amount would you like to add to you savings account?");
			savings_bal =  scan.nextInt();
			scan.nextLine();
			
		}
		if (openSavings.equals("no")) {
			System.out.println("            No problem, you can open account at any time.");

		}
		if (!openSavings.equals("yes") && !openSavings.equals("no")){
			System.out.println("            wrong input, start over.");
			addAccount(user);
		
		}
		String status = "approved";
		
		System.out.println("             Your account has been " + status);
	
		Account ac = new Account( user.getName(), checkings_bal, savings_bal, user.getUsername(), status);
		user.setAccount(ac);
		return ac;
	}
	
	public boolean usernameVerification() {
		System.out.println("             Log In by entering your account username");
		String userName = scan.nextLine();
		user = ed.getUser(userName);
		count1 = 4;
		while (count1 > 0) {
		if (user == null) {
			System.out.println("             Username does not exists, try again");
			System.out.println("             Number of tries left: " + count1);
			userName = scan.nextLine();
			user = ed.getUser(userName);
			count1--;
		}

		else if (user.getUsername().equals(userName)) {
			return true;
			}
		}
		return false;
		
	}
	
	public static boolean passwordVerification() {
		System.out.println("             Enter password");
		String passWord = scan.nextLine();
		String password = user.getPassword();
		count2 = 4;
		while (count2 > 0) {
			if (password.equals(passWord)) {
				System.out.println("             Authentication Successful!");
				return true;
				
			} else {
				System.out.println("             Password did not match username, try again");
				System.out.println("             Number of tries left: " + count2);
				passWord = scan.nextLine();
				count2--;
				
			}
			}return false;
		
	}
	
	public static void addSpace() {
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		System.out.println("                                                                                                ");
		
		
	}
	
	public void loggingOff() {
		System.out.println("             You have been logged off.");
	}
	
	

}
