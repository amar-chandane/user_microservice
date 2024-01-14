package com.amartechs.user.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amartechs.user.db.UserMap;
import com.amartechs.user.exceptions.UserBusinessException;
import com.amartechs.user.ui.model.UserRequestModel;
import com.amartechs.user.ui.model.UserResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("parameteriseduser") // localhost:8080/users/
public class PrameterisedUserController {

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) // http://localhost:8080/parameteriseduser/14444
	private ResponseEntity<UserResponseModel> getUserM(@PathVariable String userId) {
		UserResponseModel user = UserMap.getUser(userId);
		return new ResponseEntity<UserResponseModel>(user, HttpStatus.OK);
	}

	@GetMapping // http://localhost:8080/parameteriseduser/14444
	private String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "This get user is called with page " + page + " and limit=" + limit;
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel request) {
		if (true)
			throw new UserBusinessException("throwing business exception from create user method");
		// System.out.println(1/0);
		UserResponseModel response = new UserResponseModel();
		response.setEmail(request.getEmail());
		response.setUserName(request.getFirstName() + "." + request.getLastName());
		response.setUserId(request.getUserId());
		UserMap.saveUser(response);
		return new ResponseEntity(response, HttpStatus.OK);
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
