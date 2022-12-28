package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//DTO layer class to handle login request data

public class SignInDTO {
	@NotBlank(message = "Email can not be blank")
	@Email
	private String email;
	@NotBlank(message = "Password can not be blank")
	private String password;

	public SignInDTO() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public SignInDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "SignInRequest [email=" + email + ", password=" + password + "]";
	}

}
