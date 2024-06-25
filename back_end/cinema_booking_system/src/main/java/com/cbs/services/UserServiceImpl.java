package com.cbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbs.custom.exception.UserHandlingException;
import com.cbs.pojos.User;
import com.cbs.repos.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public String deleteUserById(int userId) {
		userRepo.deleteById(userId);
		return "User details deleted Successfully for userID= " + userId;
	}

	@Override
	public User updateUser(User detachedUser, User existingUser) {
		if (userRepo.existsById(existingUser.getId())) {
			
			existingUser.setName(detachedUser.getName());
			existingUser.setEmail(detachedUser.getEmail());
			existingUser.setPassword(detachedUser.getPassword());
			return userRepo.save(existingUser);
		}
		throw new UserHandlingException("Invalid user ID : Updation Failed !!!!!!!!!" + detachedUser.getId());
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new UserHandlingException("Invalid userId, coudn't find the user."));
	}

	@Override
	public User authenticate(User detachedUser) {
		
		return userRepo.getUserDetailsByNameAndPassword(detachedUser.getName(), detachedUser.getPassword());
	}

}
