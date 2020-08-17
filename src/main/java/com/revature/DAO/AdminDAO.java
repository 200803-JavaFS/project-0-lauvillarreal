package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.model.Account;

import com.revature.utilities.ConnectionUtility;

public class AdminDAO implements IAdminDAO {


	@Override
	public boolean updateAccount(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE account SET  users_name = ?, checkings_bal = ?, savings_bal = ?, status = ? WHERE users_username = ?";       
							
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, account.getName());
			statement.setDouble(++index, account.getCheckingsBalance());
			statement.setDouble(++index, account.getSavingsBalance());
			statement.setString(++index, account.getStatus());
			statement.setString(++index, account.getUsername());
			

			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteAccount(String username) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM account WHERE users_username = ?";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
