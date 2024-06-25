package com.cbs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.pojos.User;
import com.cbs.pojos.UserRole;
import com.cbs.repos.UserRepository;
import com.cbs.services.IUserService;

@SpringBootTest
class UserServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddNewUser() {
		userService.addNewUser(new User("shreyas", "shreyas@gmail.com", "1234", UserRole.CUSTOMER));
	}

	@Test
	void testFetchAllUsers() {
		userService.fetchAllUsers().forEach(u -> System.out.println(u));
	}

	@Test
	void testGetUserById() {
		System.out.println(userService.getUserById(1));
	}
	@Test
	void testGetUserDetailsByNameAndPassword() {
		System.out.println(userRepo.getUserDetailsByNameAndPassword("ramraj", "2404"));
	}

}
