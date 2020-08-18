package com.revature.services;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.AdminDAO;
import com.revature.DAO.EmployeesDAO;
import com.revature.DAO.IAdminDAO;
import com.revature.DAO.IEmployeesDAO;
import com.revature.DAO.IUserDAO;
import com.revature.DAO.UserDAO;
import com.revature.model.*;

import com.revature.utilities.*;


public class AccountServices {
	
	private static IAdminDAO aDao = new AdminDAO();
	private static IUserDAO uDao = new UserDAO();
	private static IEmployeesDAO eDao = new EmployeesDAO();
	private static final Logger log = LogManager.getLogger(AccountServices.class);
	


	
	public boolean registerUser(User user) {

		if (user.getUsername() != null) {

			List<Account> list = eDao.getAllAccounts();
			boolean b = false;
			for (Account ac : list) {
				if (ac.equals(user.getUsername())) {
					b = true;
				}
			}
			if (b) {
				log.info("Inserting User: " + user);
				if (uDao.registerUser(user)) {
					return true;
				}
			} else {
				log.info("Inserting User: " + user + " with a new Account: " + user.getAccount());
				if (uDao.registerUserWithAccount(user)) {
					return true;
				}
			}
		} else {
			log.info("Inserting User: " + user);
			if (uDao.registerUser(user)) {
				return true;
			}
		}
		return false;
	}
	
	public Account addAccount(User user) {
		System.out.println("             What amount would you like to add to your checkings account?");
		int checkings_bal = BankingApp.scan.nextInt();
		BankingApp.scan.nextLine();
		System.out.println("             Would you like to open a savings account [yes] [no] ?");
		String openSavings = BankingApp.scan.nextLine();
		int savings_bal = 0;
		if (openSavings.equals("yes")) {
			System.out.println("             What amount would you like to add to you savings account?");
			savings_bal =  BankingApp.scan.nextInt();
			BankingApp.scan.nextLine();
			
		}
		if (openSavings.equals("no")) {
			System.out.println("             No problem, you can open account at any time.");
			user.getAccount().setSavingsBalance(0);

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

	public void withdrawCheckings(Account account){
		System.out.println("            Enter widthrawal amount:");
		double amount = BankingApp.scan.nextInt();
		BankingApp.scan.nextLine();
		double checkingsBalance = account.getCheckingsBalance();
		try {
			if (amount < 0) {
				System.out.println("            Input can't be negative");
			}
			if (amount > checkingsBalance) {
				System.out.println("            Not enough funds");
			} else {
				checkingsBalance -= amount;
				account.setCheckingsBalance(checkingsBalance);
				aDao.updateAccount(account);
				System.out.println("            Withrawal complete!");
				BankingApp.addSpace();
				System.out.println("            Your checkings balance is now: " + checkingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("            Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void withdrawSavings(Account account) {
		System.out.println("            Enter widthrawal amount:");
		double amount = BankingApp.scan.nextInt();
		BankingApp.scan.nextLine(); 
		double savingsBalance = account.getSavingsBalance();
		try {
			if (amount < 0) {
				System.out.println("            Input can't be negative");
			}
			if (amount > savingsBalance) {
				System.out.println("            Not enough funds");
			} else {
				savingsBalance -= amount;
				account.setSavingsBalance(savingsBalance);
				aDao.updateAccount(account);
				System.out.println("            Withrawal complete!");
				BankingApp.addSpace();
				System.out.println("            Your savingss balance is now: " + savingsBalance );
			}
			} catch (InputMismatchException e) {
					System.out.println("        Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	

	
	public void transfer(User a, User b, double amount) {
		try {
			Double balance1= a.getAccount().getCheckingsBalance();
			if (amount < 0) {
				System.out.println("            Input can't be negative");
			}
			if (amount > balance1) {
				System.out.println("            Not enough funds");
			} else {
		balance1 -= amount;
		a.getAccount().setCheckingsBalance(balance1);
		Double balance2= b.getAccount().getCheckingsBalance();
		balance2 += amount;
		b.getAccount().setCheckingsBalance(balance2);
		eDao.transfer(a,b);
		System.out.println("            You have successfully transfered " + amount + " to " + b.getName());
		System.out.println("                                                              ");
		System.out.println("            Your account balance is now : " + balance1);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("            Invalid Input");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void depositCheckings(Account account) {
		System.out.println("            Enter deposit amount:");
		double amount = BankingApp.scan.nextInt();
		BankingApp.scan.nextLine();
		double checkings_bal = account.getCheckingsBalance();
		try {
			if (amount < 0) {
				System.out.println("            Input can't be negative");
			
			} else {
				checkings_bal += amount;
				account.setCheckingsBalance(checkings_bal);
				aDao.updateAccount(account);
				System.out.println("            Deposit complete!");
				BankingApp.addSpace();
				System.out.println("            Your checkings balance is now:   " + checkings_bal );
				
			}
			} catch (InputMismatchException e) {
					System.out.println("            Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void depositSavings(Account account) {
		System.out.println("            Enter deposit amount:");
		double amount = BankingApp.scan.nextInt();
		BankingApp.scan.nextLine();
		double savings_bal = account.getSavingsBalance();
		try {
			if (amount < 0) {
				System.out.println("            Input can't be negative");
			
			} else {
				savings_bal += amount;
				account.setSavingsBalance(savings_bal);
				aDao.updateAccount(account);
				System.out.println("            Deposit complete!");
				BankingApp.addSpace();
				System.out.println("            Your savingss balance is now:   " + savings_bal );
		
			}
			} catch (InputMismatchException e) {
					System.out.println("           Invalid Input");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void updateSetLoggedIn(boolean b, User user) {
		try {
			uDao.updateLoggedin(user, b);
		} catch (Exception e) {
			
		}
	}

	public void getAllAccounts() {
		List<Account> list = eDao.getAllAccounts();
		int a = list.size();
		System.out.println(a);
		for (Account b : list) {
			System.out.print(b + "");
		}
	}


	




	

}
