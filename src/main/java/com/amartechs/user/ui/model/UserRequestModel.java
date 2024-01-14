package com.amartechs.user.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestModel {
	private String userName;
	@NotNull(message = "first name cannot be null")
	private String firstName;
	@NotNull(message = "first name cannot be null")
	private String lastName;
	private String userId;

	@NotNull(message = "email cannot be null")
	@Email
	private String email;
	@NotNull(message = "password cannot be null")
	@Size(min = 5, max = 15, message = "password must be at least 5 letter or maximums 15 letters long")
	private String password;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
