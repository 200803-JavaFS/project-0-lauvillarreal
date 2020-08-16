package com.revature.DAO;



import com.revature.model.Account;

public interface IAdminDAO {
/* Bank admins should be able to view and edit all accounts. This includes:
	--approving/denying accounts
	--withdrawing, depositing, transferring from all accounts
	--canceling accounts
*/
	
	public boolean updateAccount(Account account);
	public boolean deleteAccount(String username);
	
	

}
