package com.revature.model;

public class User {
	// SQL: create user bob with password 'mypass';
	private String username;
	private String password;
	private String name;
	private boolean isLoggedIn;
	private String type;
	private Account account;
	private String usersID;
	


	public User() {
		super();
	}
	
	public User(String username, String password, String name, boolean isLoggedIn) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.isLoggedIn = isLoggedIn;
	}
	
	
	public User(String username, String password, String name, boolean isLoggedIn, String type, Account account,
			String usersID) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.isLoggedIn = isLoggedIn;
		this.type = type;
		this.account = account;
		this.usersID = usersID;
	}

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	

	public User(String username, String password, String name, boolean isLoggedIn, String type) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.isLoggedIn = isLoggedIn;
		this.type = type;
	}
	
	
	public User(String username, String password, String name, boolean isLoggedIn, String type, Account account) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.isLoggedIn = isLoggedIn;
		this.type = type;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	public  String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	public static void setLoggedIn(boolean isLoggedIn) {
		isLoggedIn = isLoggedIn;
	}
	 
	public String getUsersID() {
		return usersID;
	}

	public void setUsersID(String usersID) {
		this.usersID = usersID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (isLoggedIn ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (isLoggedIn != other.isLoggedIn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", isLoggedIn=" + isLoggedIn
				+ ", type=" + type + ", account=" + account + "]";
	}

	




	

	
	
	
	
	

}
