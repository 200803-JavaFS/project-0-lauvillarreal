package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtility;

public class EmployeesDAO implements IEmployeesDAO {

	

	@Override
	public List<Account> getAllAccounts() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM account;";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account a = new Account(result.getString("users_name"), result.getDouble("checkings_bal"),
						result.getDouble("savings_bal"), result.getString("users_username"),
						result.getString("status"));
				
				list.add(a);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountByUsername(String username) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM account WHERE users_username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Account a = new Account();
				a.setName(result.getString("users_name"));
				a.setCheckingsBalance(result.getDouble("checkings_bal"));
				a.setSavingsBalance(result.getDouble("savings_bal"));
				a.setUsername(result.getString("users_username"));
				a.setStatus(result.getString("status"));
				return a;
			} else {
				//good place to log a failed query.
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<User> getAllUsers(User user) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM avengers;";

			Statement statement = conn.createStatement();

			List<User> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				User u = new User(result.getString("users_username_fk"), result.getString("users_password"),
						result.getString("users_name"),result.getBoolean("isloggedin"), result.getString("users_type"),
					    null, result.getString("users_id"));
				if (result.getString("users_username_fk") != null) {
					u.setAccount(getAccountByUsername(result.getString("users_username_fk")));
				}
				list.add(u);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUser(User user) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM avengers;";

			Statement statement = conn.createStatement();

			User u = null;

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				u = new User(result.getString("users_username_fk"), result.getString("users_password"),
						result.getString("users_name"),result.getBoolean("isloggedin"), result.getString("users_type"),
					    null, result.getString("users_id"));
				if (result.getString("users_username_fk") != null) {
					u.setAccount(getAccountByUsername(result.getString("users_username_fk")));
				}
				
			}
			return u;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean setStatus(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE account SET status = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, account.getStatus());
		
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
