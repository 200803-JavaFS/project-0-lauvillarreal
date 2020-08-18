package com.revature.DAO;

import java.util.*;

import com.revature.model.*;

public interface IEmployeesDAO {
/*	Employees of the bank should be able to view all of their customers information. This includes:
		--Account information
		--Account balances
		--Personal information
    Employees should be able to approve/deny open applications for accounts
		
*/
	
	public List<Account> getAllAccounts();
	public Account getAccountByUsername(String username);
	public boolean transfer(User user1, User user2 );
	public User getUserByUsername(String username);;
	public User getUserByID(int ID);
	public List<User> getAllUsers();
	public boolean setStatus(Account account);

}
