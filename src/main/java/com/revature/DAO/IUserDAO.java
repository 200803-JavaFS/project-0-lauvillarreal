package com.revature.DAO;

import com.revature.model.*;
import java.util.*;

public interface IUserDAO {
	
	
	public boolean registerUser(User user);
	public boolean registerUserWithAccount(User user);
	public boolean updateLoggedin(User user);
	public boolean addAccount(Account account);
	

}
