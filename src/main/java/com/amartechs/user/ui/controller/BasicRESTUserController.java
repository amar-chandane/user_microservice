package com.amartechs.user.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // localhost:8080/users/
public class BasicRESTUserController {

	@GetMapping // localhost:8080/users/ (Http method GET)
	private String getUser() {
		return "get user is called";
	}

	@PostMapping // localhost:8080/users/ (Http method POST)
	private String createUser() {
		return "post user is called";
	}

	@PutMapping // localhost:8080/users/ (Http method PUT)
	private String updateUser() {
		return "put user is called";
	}

	@DeleteMapping // localhost:8080/users/ (Http method DELETE)
	private String deleteUser() {
		return "delete user is called";

	}
}
