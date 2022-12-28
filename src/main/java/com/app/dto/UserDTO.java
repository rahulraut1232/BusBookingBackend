package com.app.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.Role;

//DTO layer class to handle sign up request data

public class UserDTO {
	@NotBlank(message = "Name can not be empty")
	private String name;
	@NotBlank(message = "Email is required")
	@Length(min = 5,max = 40,message = "Invalid Email length")
	@Email(message = "Invalid email format")
	private String email;
	@Length(max = 40)
	private String Address;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password!")
	private String password;
//	@Pattern(regexp = "/^([+]\\d{2})?\\d{10}$/\r\n", message = "Invalid mobile number")
	private String mobile;
	private char gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String email, String address, String password, String mobile, char gender,
			LocalDate dob, Role role) {
		super();
		this.name = name;
		this.email = email;
		Address = address;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", Address=" + Address + ", password=" + password
				+ ", mobile=" + mobile + ", gender=" + gender + ", dob=" + dob + ", role=" + role + "]";
	}

		
}
