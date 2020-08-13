package com.revature.DAO;

import java.util.*;

import com.revature.model.Account;

public interface EmployeesDAO  {
/*	Employees of the bank should be able to view all of their customers information. This includes:
		--Account information
		--Account balances
		--Personal information
    Employees should be able to approve/deny open applications for accounts
		
*/
	
	public List<Account> getAllAccounts();
	public List<Account> getAccountById(UUID Id);
	public List<Account> getAccountByName(String name);
	public List<String> getAccountTransactions();
	
	
	public boolean approveAccount(Account account);
	public boolean denyAccountById(Account account);
	public boolean updateAccount(Account account);
	public boolean deleteAccountById(UUID Id);
	
}
