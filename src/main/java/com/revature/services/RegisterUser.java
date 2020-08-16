package com.revature.services;

import java.util.*;
import com.revature.utilities.*;
import com.revature.model.User;
import com.revature.main.*;

public class RegisterUser extends User {
	
	
	public RegisterUser()  {
		super();
		
		//Name
		System.out.println("             Enter your first and last name");
		String Name = BankingApp.scan.nextLine();
		setName(Name);
		
		//Username
		System.out.println("             Enter a username");
		String username = BankingApp.scan.nextLine();
		setUsername(username);
		
		//Password
		System.out.println("             Enter a password");
		String password = BankingApp.scan.nextLine();
		setPassword(password);
		
		//Name
		System.out.println("             Are you a new [customer] [admin] [employee] ? ");
		String type = BankingApp.scan.nextLine();
		setType(type);
		
		//LogIn
		System.out.println("             Thank you " + Name + " for registering with Velox Bank");
		BankingApp.addSpace();
		System.out.println("             Select one of the following options. To exit, press exit.");
		
		
		
		
	}
	
	


}
