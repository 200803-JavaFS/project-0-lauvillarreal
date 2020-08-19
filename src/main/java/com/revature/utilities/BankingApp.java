package com.revature.utilities;

import java.util.InputMismatchException;
import java.util.List;
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

	
	public void application() {
		
		log.info("The application has started");
	
		//Logo
		logo();
		
		//Introducing Velox Bank 
		introduction();

		
		//Logging In/Registering Menu
		loginAndRegisterMenu();
		
		//Determine type of user
		if (user != null) {
			if (user.getType().equals("admin")) {
				adminMenu();
			}
			else if (user.getType().equals("customer")) {
				if (user.getAccount().getStatus().equals("approved")) {
						serviceMenu();
				}else {
					System.out.println("            Your account has not been approved");
					loginAndRegisterMenu();
				}
			
			}
			else if (user.getType().equals("employee")){
				employeeMenu();
			}
			else {
				System.out.println("          User does not exist");
			}
	
		
		}
		log.info("The application is ending") ;
	}
	
	
	private void adminMenu() {
		System.out.println("            Select one of the following options.");
		System.out.println("____________________________________________________________________________________________________________________");
		System.out.println("     [Account Balances/Info (B)] [Deposit/Withdraw/transer (D)] [Approve/Deny/Cancel Accounts (A)] [Exit (E)]"  );
		System.out.println("____________________________________________________________________________________________________________________");
		String answer = scan.nextLine().toLowerCase(); 
		answerSwitch4(answer);
		
	}





	private void answerSwitch4(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "b":
				try {
				System.out.println("            Would you like to see a single user's acccount balance/info [u] or all balances [a] ? ");
				String input = scan.nextLine().toLowerCase();
				if (input.equals("u")) {
					System.out.println("            Enter the Accound ID :");
					int accID = scan.nextInt();
					scan.nextLine();
					User accUser = new User();
					accUser = ed.getUserByID(accID);
					System.out.println(accUser.getAccount());
					addSpace();
					adminMenu();
				}
				else if (input.equals("a")) {
					as.getAllAccounts();
					adminMenu();
				}else {
					System.out.println("            Wrong input.. Start Over");
					addSpace();
					adminMenu();
					
				}
				
				} catch (InputMismatchException e) {
					System.out.println("            Wrong Input. Start Over...");
					addSpace();
					adminMenu();
				} catch (NullPointerException e) {
					System.out.println("          Accound ID does not exists.. Start Over");
					addSpace();
					adminMenu();
				}
				break;
			case "d":
				try {
					System.out.println("            Would you like to Deposit [D] Withdraw [W] Transfer [F] from Accounts ?");
					String input = scan.nextLine().toLowerCase();
					if (input.equals("d")) {
						System.out.println("            Enter the Users ID :");
						int usrID = scan.nextInt();
						scan.nextLine();
						user = ed.getUserByID(usrID);
						choiceOfAccount();
						addSpace();
						adminMenu();
						
					}
					if (input.equals("w")) {
						System.out.println("            Enter the Users ID :");
						int usrID = scan.nextInt();
						scan.nextLine();
						user = ed.getUserByID(usrID);
						choiceOfAccount2();
						addSpace();
						adminMenu();
						
					}
					else if (input.equals("t")) {
							System.out.println("            Enter the Account ID that you would like to transfer FROM : ");
							int sendingID = scan.nextInt();
							scan.nextLine();
							System.out.println("            Enter the Account ID that you would like to transfer TO : ");
							int receivingID = scan.nextInt();
							scan.nextLine();
							System.out.println("            How much would you like to transfer?  ");
							int amount = scan.nextInt();
							scan.nextLine();
							if (checkIfItExists(receivingID) && checkIfItExists(sendingID)) {
								 User receiving = new User();
								 User sending = new User();
								 sending = ed.getUserByID(sendingID);
								 receiving = ed.getUserByID(receivingID);
								 as.transfer(sending,receiving, amount);
								 adminMenu();
							 } else {
								 System.out.println("            Account ID does not exist... Start Over ");
								 adminMenu();
							 }
							
					}else {
						System.out.println("            Wrong input.. Start Over");
						addSpace();
						adminMenu();
						
					}
					
					} catch (InputMismatchException e) {
						System.out.println("            Wrong Input. Start Over...");
						addSpace();
						adminMenu();
					} catch (NullPointerException e) {
						System.out.println("          Accound ID does not exists.. Start Over");
						addSpace();
						adminMenu();
					}
				
				break;
			case "a":
				try {
				System.out.println("            Would you like to approve/deny/cancel a single user [u] or all users [a]");
				String input = scan.nextLine().toLowerCase();
				if (input.equals("u")) {
					System.out.println("            Enter the Users ID :");
					int usrID = scan.nextInt();
					scan.nextLine();
					user = ed.getUserByID(usrID);
					System.out.println("            Would you like to [approved] or [denied] or [cancelled] ? Type as indicated inside brackets.");
					String status = scan.nextLine();
					if (status.equals("approved")) {
						as.approveAccount("pending", user);
						addSpace();
						adminMenu();
					} 
					else if (status.equals("denied")) {
						as.denyAccount("pending", user);
						addSpace();
						adminMenu();
					}
					else if (status.equals("cancelled")) {
							as.cancelAccount("pending", user);
							addSpace();
							adminMenu();
					}else {
						System.out.println("            Wrong input.. Start Over");
						adminMenu();
					}
				}
				if (input.equals("a")) {
					as.approveAllcounts();
					addSpace();
					adminMenu();	
				}
				} catch (InputMismatchException e) {
					System.out.println("            Wrong Input. Start Over...");
					addSpace();
					adminMenu();
				} catch (NullPointerException e) {
					System.out.println("          Accound ID does not exists.. Start Over");
					addSpace();
					adminMenu();
				}
				
				break;
			case "e":
				System.out.println("            Thank you for using the application. Hope to see you soon!");
				as.updateSetLoggedIn(false, user);
				addSpace();
				break;
			default:
				System.out.println("            You have entered an incorrect value. Please try again. ");
				addSpace();
				adminMenu();
				break;
		}
	}

	
	
	
	
	private void employeeMenu() {
		System.out.println("            Select one of the following options.");
		System.out.println("____________________________________________________________________________________________________________________");
		System.out.println("     [Account Balances/Info (B)] [Customer Personal Information (P)] [Approve/Deny Accounts (A)] [Exit (E)]"  );
		System.out.println("____________________________________________________________________________________________________________________");
		String answer = scan.nextLine().toLowerCase(); 
		answerSwitch3(answer);
		
	}





	private void answerSwitch3(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "b":
				try {
				System.out.println("            Would you like to see a single user's acccount balance/info [u] or all balances [a] ? ");
				String input = scan.nextLine().toLowerCase();
				if (input.equals("u")) {
					System.out.println("            Enter the Accound ID :");
					int accID = scan.nextInt();
					scan.nextLine();
					User accUser = new User();
					accUser = ed.getUserByID(accID);
					System.out.println(accUser.getAccount());
					addSpace();
					employeeMenu();
				}
				else if (input.equals("a")) {
					System.out.println(ed.getAllUsers());
					employeeMenu();
				}else {
					System.out.println("            Wrong input.. Start Over");
					addSpace();
					employeeMenu();
					
				}
				
				} catch (InputMismatchException e) {
					System.out.println("            Wrong Input. Start Over...");
					addSpace();
					employeeMenu();
				} catch (NullPointerException e) {
					System.out.println("          Accound ID does not exists.. Start Over");
					addSpace();
					employeeMenu();
				}
				break;
			case "p":
				try {
					System.out.println("            Would you like to see a single user's personal info [u] or all user's info [a] ? ");
					String input = scan.nextLine().toLowerCase();
					if (input.equals("u")) {
						System.out.println("            Enter the Users ID :");
						int usrID = scan.nextInt();
						scan.nextLine();
						user = ed.getUserByID(usrID);
						System.out.println(user);
						addSpace();
						employeeMenu();
						
					}
					else if (input.equals("a")) {
						as.getAllAccounts();
					}else {
						System.out.println("            Wrong input.. Start Over");
						addSpace();
						employeeMenu();
						
					}
					
					} catch (InputMismatchException e) {
						System.out.println("            Wrong Input. Start Over...");
						addSpace();
						employeeMenu();
					} catch (NullPointerException e) {
						System.out.println("          Accound ID does not exists.. Start Over");
						addSpace();
						employeeMenu();
					}
				
				break;
			case "a":
				String status = user.getAccount().getStatus();
				as.approveAccount(status, user);
				
				break;
			case "e":
				System.out.println("            Thank you for using the application. Hope to see you soon!");
				as.updateSetLoggedIn(false, user);
				System.out.println("here in e");
				addSpace();
				break;
			default:
				System.out.println("            You have entered an incorrect value. Please try again. ");
				addSpace();
				employeeMenu();
				break;
		}
	}





	public void logo(){
		Logo logo = new Logo();
	}
	
	public void serviceMenu() {
		System.out.println("            Select one of the following options.");
		System.out.println("____________________________________________________________________________________________________________________");
		String checkingsBalance = "Checkings Balance";
		String savingsBalance = "Savings Balance";
		String makeDeposit = "Deposit";
		String makeWithdrawal = "Withdrawal";
		String makeTransfer = "Transfer";
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
				break;
			case "s":
				if (user.getAccount().getSavingsBalance() == 0) {
					System.out.println("            You do not have a savings account.");
				} else {
				account = ed.getAccountByUsername(user.getUsername());
				Double savings_bal = account.getSavingsBalance();
				System.out.println("            Your savings has a balance of: " + savings_bal);
				serviceMenu();
				}
				break;
			case "d":
				choiceOfAccount();
				serviceMenu();
				break;
			case "w":
				choiceOfAccount2();
				serviceMenu();
				break;
			case "t":
				try {
				System.out.println("            Enter the Account ID that you would like to transfer to : ");
				int receivingID = scan.nextInt();
				scan.nextLine();
				System.out.println("            How much would you like to transfer?  ");
				int amount = scan.nextInt();
				scan.nextLine();
				if (checkIfItExists(receivingID)) {
					 User receiving = new User();
					 receiving = ed.getUserByID(receivingID);
					 as.transfer(user,receiving, amount);
					 serviceMenu();
				 } else {
					 System.out.println("            Account ID does not exist... Start Over ");
					 serviceMenu();
				 }
				} catch (InputMismatchException e) {
					System.out.println("            You have entered wrong input. Start Over.... ");
					serviceMenu();
				}
				break;
			case "e":
				System.out.println("            Thank you for using the application. Hope to see you soon!");
				as.updateSetLoggedIn(false, user);
				addSpace();
				break;
			default:
				System.out.println("            You have entered an incorrect value. Please try again. ");
				serviceMenu();
				break;
		}
	}
	
	private boolean checkIfItExists(int receivingID) {
		try {
		User receiving = new User();
		receiving = ed.getUserByID(receivingID);
		if (receiving == null) {	
			return false;
		} else {
			return true;
		}
		} catch (NullPointerException e) {
				System.out.println("           Invalid Input");
		} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}





	public boolean choiceOfAccount() {
		account = ed.getAccountByUsername(user.getUsername());
		System.out.println("            Would you like to deposit to Checkings [C] or Savings [S] ?");
		String choice = scan.nextLine().toLowerCase();
		if(choice.equals("c")) {
			as.depositCheckings(account);
			addSpace();
			return true;
			
		}
		else if(choice.equals("s")) {
			as.depositSavings(account);
			addSpace();
			return true;
		
		}
		else {
			System.out.println("            Wrong input, back to Main Menu.");
			return false;
		
			
		}
	}
	public boolean choiceOfAccount2() {
		account = ed.getAccountByUsername(user.getUsername());
		System.out.println("            Would you like to withdraw from Checkings [C] or Savings [S] ?");
		String choice = scan.nextLine().toLowerCase();
		if(choice.equals("c")) {
			as.withdrawCheckings(account);
			addSpace();
			return true;
			
		}
		else if(choice.equals("s")) {
			as.withdrawSavings(account);
			addSpace();
			return true;
		
		}
		else {
			System.out.println("            Wrong input, back to Main Menu.");
			return false;
		
			
		}
	}
	public void introduction() {
		System.out.println("                                    Welcome to Velox Bank");
		System.out.println("                                  Where Banking Is Made Simple");
		addSpace();
	}

	
	public void login() {
		if(usernameVerification() && passwordVerification()) {
			if (user.getAccount().getStatus().equals("approved")) {
			System.out.println("             You are now logged in.");
			addSpace();
			}else {
				
			}
			
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
				as.updateSetLoggedIn(true,user);
				break;
			case "register":
				RegisterUser();
				as.updateSetLoggedIn(true,user);
				break;
			case "exit":
				System.out.println("             Thank you for using the application. Hope to see you soon!");
				addSpace();
				as.updateSetLoggedIn(false,user);
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
		String Name = scan.nextLine();
	
		
		//Username
		System.out.println("             Enter a username");
		String username = scan.nextLine();
		
		
		//Password
		System.out.println("             Enter a password");
		String password = scan.nextLine();
		
		
		//Name
		System.out.println("             Are you a new Customer[C] Admin[A] Employee[E] ? ");
		String type = scan.nextLine().toLowerCase();
		if (type.equals("c")) {
			type = "customer";
		}
		else if (type.equals("a")) {
			type = "admin";
		}
		else if (type.equals("e")) {
			type = "employee";
		}
		else {
			System.out.println("            You have not entered the right input. Start Over...");
			RegisterUser();
		}
		
		//Add account when registering
		System.out.println("             Thank you " + Name + " for registering with Velox Bank!");
		user = new User(username, password, Name, true, type);
		as.addAccount(user);
		as.registerUser(user);
	
	
		
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
	
	
	
	public boolean usernameVerification() {
		System.out.println("             Log In by entering your account username");
		String userName = scan.nextLine();
		user = ed.getUserByUsername(userName);
		count1 = 4;
		while (count1 > 0) {
		if (user == null) {
			System.out.println("             Username does not exists, try again");
			System.out.println("             Number of tries left: " + count1);
			userName = scan.nextLine();
			user = ed.getUserByUsername(userName);
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
