package com.revature.model;

import java.util.*;
import com.revature.main.Driver;

public class RegisterUser{
	
	public String username;
	public String password;
	public static String name;
	
	
	public RegisterUser()  {
		super();
		
		//Name
		System.out.println("             Enter your first and last name");
		String Name = Driver.scan.nextLine();
		setName(Name);
		
		//Username
		System.out.println("             Enter a username");
		String username = Driver.scan.nextLine();
		setUsername(username);
		
		//Password
		System.out.println("             Enter a password");
		String password = Driver.scan.nextLine();
		setPassword(password);
		
		//LogIn
		System.out.println("             Thank you " + Name + " for registering with Velox Bank");
		System.out.println("             Please Log In to access account");
		
		
		
		
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		RegisterUser.name = name;
	}

}
