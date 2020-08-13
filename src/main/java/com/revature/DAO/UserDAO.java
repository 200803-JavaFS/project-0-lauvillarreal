package com.revature.DAO;

import com.revature.model.*;
import java.util.*;

public interface UserDAO {
	
	public List<User> getUsers();
	public User getUserById(String id);
	public List<Account> getAllAccounts();
	public List<Account> getAccountById(String Id);
	public List<Account> getAccountByName(String name);
	public List<String> getAccountTransactions();
	
	
	public boolean approveAccount(Account account);
	public boolean denyAccountById(Account account);
	public boolean updateAccount(Account account);
	public boolean deleteAccountById(String Id);
	public boolean depositByAccountId(int amount);
	public boolean withdrawByAccountId(int amount);
	public boolean transferfromAccountIdToId(int amount);
	
	

}
