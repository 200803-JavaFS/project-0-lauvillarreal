package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.model.*;
import com.revature.utilities.ConnectionUtility;

public class UserDAO implements IUserDAO {

	@Override
	public boolean registerUser(User user) {
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO users (users_password, isloggedin, users_type, users_username_fk, users_name)"
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, user.getPassword());
			statement.setBoolean(++index, user.isLoggedIn());
			statement.setString(++index, user.getType());
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getName());
			
			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			System.out.println("error here");
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public boolean registerUserWithAccount(User user) {
	
			try (Connection conn = ConnectionUtility.getConnection()){
				
				String sql = "BEGIN; "
						+ "INSERT INTO account (users_username, users_name, checkings_bal, savings_bal, status)"
						+ "VALUES (?, ?, ?, ?, ?);"
						+ "INSERT INTO users (users_password, isloggedin, users_type, users_username_fk, users_name)"
						+ "VALUES (?, ?, ?, ?, ?);"
						+ "COMMIT;";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				Account a = user.getAccount();
				
		
				int index = 0;
				statement.setString(++index, a.getUsername());
				statement.setString(++index, a.getName());
				statement.setDouble(++index, a.getCheckingsBalance());
				statement.setDouble(++index, a.getSavingsBalance());
				statement.setString(++index, a.getStatus());
				statement.setString(++index, user.getPassword());
				statement.setBoolean(++index, user.isLoggedIn());
				statement.setString(++index, user.getType());
				statement.setString(++index, a.getUsername());
				statement.setString(++index, user.getName());
				
			
				
				statement.execute();
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public boolean updateLoggedin(User user) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE users SET isloggedin = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setBoolean(1, user.isLoggedIn());
		
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addAccount(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO account (users_username, users_name, checkings_bal, savings_bal, status)"
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
		
			int index = 0;
			statement.setString(++index, account.getUsername());
			statement.setString(++index, account.getName());
			statement.setDouble(++index, account.getCheckingsBalance());
			statement.setDouble(++index, account.getSavingsBalance());
			statement.setString(++index, account.getStatus());
			
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
