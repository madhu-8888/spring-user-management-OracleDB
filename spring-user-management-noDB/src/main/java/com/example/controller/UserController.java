package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	// Constructor Injection (for real apps)
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/getAllUsers", produces = "application/json")
	public List<User> getAllUsers() throws SQLException {
		return userService.getAllUsers();
	}

	@PostMapping("/createUser")
	public void createUser(@RequestBody User user) throws SQLException {
		userService.createUser(user);
	}

	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User user) throws SQLException {
		user.setId(id);
		userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) throws SQLException {
		userService.deleteUser(id);
	}
}