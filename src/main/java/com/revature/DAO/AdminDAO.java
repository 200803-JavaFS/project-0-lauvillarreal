package com.revature.DAO;

import java.util.List;

import com.revature.model.Account;

public interface AdminDAO {
/* Bank admins should be able to view and edit all accounts. This includes:
	--approving/denying accounts
	--withdrawing, depositing, transferring from all accounts
	--canceling accounts
*/
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
