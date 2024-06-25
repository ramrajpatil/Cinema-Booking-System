package com.cbs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbs.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// Method generates a query to get user details by name and password and returns a persistent user
	User getUserDetailsByNameAndPassword(String name, String password);

	// select a method to add / register new user.
		// save(Object ref);
}
