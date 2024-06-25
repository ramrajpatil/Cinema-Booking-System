package com.cbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.dto.ErrorResponse;
import com.cbs.dto.ResponseDTO;
import com.cbs.pojos.User;
import com.cbs.services.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private IUserService userService;

	public UserRestController() {
		System.out.println("In user rest controller.");
	}

	// Adding REST API end point: for getting all users.
	@GetMapping
	public List<User> getAllUsers() {
		System.out.println("In getAllUsers() " + getClass().getName());
		return userService.fetchAllUsers();
	}

	// Adding REST API to create new user details.
	@PostMapping
	public ResponseEntity<?> addNewUserDetails(@RequestBody User transientUser) {
		// invoke service layer's method to add new user.
		try {
			return new ResponseEntity<>(userService.addNewUser(transientUser), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("Error in " + getClass().getName() + e);
			return new ResponseEntity<>(new ErrorResponse("Adding user details failed!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Adding REST API to delete user details by Id
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId) {

		System.out.println("In deleteUserDetails " + userId);
		// Invoke service layer's method for deleting user details.
		return ResponseEntity.ok(new ResponseDTO(userService.deleteUserById(userId)));
	}

	// Adding REST API to get existing user details by id
	@GetMapping("/{UserId}")
	public ResponseEntity<?> getUserDetails(@PathVariable int UserId) {
		System.out.println("In getUserDetails by id= " + UserId);
		try {
			// invoke service layer's method to get existing user details
			return ResponseEntity.ok(userService.getUserById(UserId));
		} catch (RuntimeException e) {
			System.out.println("Error in getUserDetails() of " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Fetching user details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}

	// Adding REST API end point to update existing user details
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@RequestBody User detachedUser, @PathVariable int id) {
		System.out.println("In updateUserDetails " + getClass().getName() + "  " + detachedUser + "  " + id);
		try {
			return ResponseEntity.ok(userService.updateUser(detachedUser, userService.getUserById(id)));
		} catch (RuntimeException e) {
			System.out.println("Error in updateUserDetails() of " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Updating user details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	// Adding REST API end point to authenticate the user
	@PostMapping("/auth")
	public ResponseEntity<?> authenticateUser(@RequestBody User detachedUser){
		System.out.println("In authenticateUser " + getClass().getName() + "  " + detachedUser + "  ");
		try {
			return ResponseEntity.ok(userService.authenticate(detachedUser));
		} catch (RuntimeException e) {
			System.out.println("Error in updateUserDetails() of " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Updating user details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}

}
