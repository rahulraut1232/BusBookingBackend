  package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ChangePasswordDTO;
import com.app.dto.ErrorDTO;
import com.app.dto.JwtDTO;
import com.app.dto.SignInDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.UserServiceImpl;
import com.app.util.JwtTokenUtil;

//rest controller for all requests related to user

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userService;

	public UserController() {
		System.out.println("in constructor of " + getClass().getName());
	}

//	sign in request to enter the application
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInDTO request, BindingResult br) throws Exception{
		System.out.println("in authenticate user " + request);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		User user = userService.authenticateUser(request);
		System.out.println(user);
		
//		call method of AuthenticationManager
		authenticate(request.getEmail(), request.getPassword());
		UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
		
		final String token = jwtTokenUtil.generateToken(userDetails);    
		return new ResponseEntity<>(new JwtDTO(user, token), HttpStatus.OK);
	}
	
//	sign up request to add new user in application as passenger
	@PostMapping("/signup")
	public ResponseEntity<?> addUser (@Valid @RequestBody UserDTO userDTO, BindingResult br){
		System.out.println("in add user "+userDTO);
		if(br.hasFieldErrors()) {
			System.out.println(br);
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		}
		userDTO.setRole(Role.PASSENGER);
		return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
	}
	
//	change password request
	@PutMapping("/change-password/{uId}")
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO passwordDTO, BindingResult br, @PathVariable int uId){
		System.out.println("in change password "+passwordDTO+" "+uId);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(userService.changePassword(passwordDTO, uId), HttpStatus.OK);
	}
	
//	edit profile request
	@PostMapping("/edit-profile/{uId}")
	public ResponseEntity<?> editProfile(@PathVariable Integer uId, @RequestBody UserDTO userDTO, BindingResult br){
		System.out.println("in edit profile "+uId+" "+userDTO);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(userService.editProfile(uId, userDTO), HttpStatus.OK);
	}
	
	@PostMapping("/edit-profile-manager/{uId}")
	public ResponseEntity<?> editProfile2(@PathVariable Integer uId, @RequestBody UserDTO userDTO, BindingResult br){
		System.out.println("in edit profile "+uId+" "+userDTO);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(userService.editProfile(uId, userDTO), HttpStatus.OK);
	}
	@PostMapping("/edit-profile-owner/{uId}")
	public ResponseEntity<?> editProfile3(@PathVariable Integer uId, @RequestBody UserDTO userDTO, BindingResult br){
		System.out.println("in edit profile "+uId+" "+userDTO);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(userService.editProfile(uId, userDTO), HttpStatus.OK);
	}
	
//	delete account request
	@DeleteMapping("/delete-account/{aId}")
	public ResponseEntity<?> deleteAccount(@PathVariable Integer aId) {
		System.out.println("Delete Account "+aId);
		return new ResponseEntity<>(userService.deleteAccount(aId), HttpStatus.OK);
		//return ResponseEntity.ok(userService.deleteAccount(id));
	}
	
//	user account authorization request
	@GetMapping("/authorize/{userId}")
	public ResponseEntity<?> authorizeAccount(@PathVariable Integer userId){
		System.out.println("in authorize acccount "+userId);
		return new ResponseEntity<>(userService.authorizeUser(userId), HttpStatus.OK);
	}
	
//	user view profile request
	@GetMapping("/view-profile/{userId}")
	public ResponseEntity<?> viewProfile(@PathVariable Integer userId){
		System.out.println("in view-profile, user id :  "+userId);
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	@GetMapping("/view-profile-manager/{userId}")
	public ResponseEntity<?> viewProfile2(@PathVariable Integer userId){
		System.out.println("in view-profile2, user id :  "+userId);
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	@GetMapping("/view-profile-owner/{userId}")
	public ResponseEntity<?> viewProfile3(@PathVariable Integer userId){
		System.out.println("in view-profile2, user id :  "+userId);
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}
	
//	need to call this method while authentication using AuthenticationManager
	private void authenticate(String name, String password) throws Exception {
		try {
		System.out.println("in auth manager authenticate : name : "+name + " password : "+password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));
			System.out.println("authenticated successfully...");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
