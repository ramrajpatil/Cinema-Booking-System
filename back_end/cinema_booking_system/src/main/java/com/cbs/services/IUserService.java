package com.cbs.services;

import java.util.List;

import com.cbs.pojos.User;

public interface IUserService {

	User addNewUser(User user);
	
	List<User> fetchAllUsers();
	
	User getUserById(int userId);
	
	String deleteUserById(int userId);
	
	User updateUser(User detachedUser, User existingUser);

	User authenticate(User detachedUser);

}
