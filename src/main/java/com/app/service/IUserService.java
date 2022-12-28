package com.app.service;

import com.app.dto.ChangePasswordDTO;
import com.app.dto.SignInDTO;
import com.app.dto.UserDTO;
import com.app.dto.ViewProfileDTO;
import com.app.pojos.User;

//service layer interface to declare user related methods

public interface IUserService {
	
//	method to authenticate new user through given email and password
	public User authenticateUser(SignInDTO request);
	
//	method to add new user
	public String addUser(UserDTO userDTO);
	
//	method to change password
	public String changePassword(ChangePasswordDTO passwordDTO, Integer uId);
	
//	method to edit profile
	public String editProfile(Integer uid, UserDTO userdto);
	
//	method to delete account of user
	public String deleteAccount(Integer aId);
	
//	method to authorize user account
	public String authorizeUser(Integer userId);
	
//	method to get user details
	public ViewProfileDTO getUserDetails(Integer userId);
}
