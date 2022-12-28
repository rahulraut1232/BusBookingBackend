package com.app.service;

import java.util.ArrayList;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_excs.MailHandlingException;
import com.app.custom_excs.UserHandlingException;
import com.app.dao.UserRepository;
import com.app.dto.ChangePasswordDTO;
import com.app.dto.SignInDTO;
import com.app.dto.UserDTO;
import com.app.dto.ViewProfileDTO;
import com.app.pojos.AuthStatus;
import com.app.pojos.User;

//service layer class to define user related methods

@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Value("${subject}")
	private String subject;

//	@Value("${text}")
//	private String text;
	
	@Value("${text1}")
	private String text1;
	
	@Value("${text2}")
	private String text2;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public User authenticateUser(SignInDTO request) {
		User user = userRepo.findByEmail(request.getEmail());
		if(user == null)
			throw new UserHandlingException("Invalid credentials...");
		boolean matches = bcryptEncoder.matches(request.getPassword(), user.getPassword());
		System.out.println("matches : "+matches);
		if(!matches)
			throw new UserHandlingException("Invalid credentials...");
		return user;
	}

//	java mail sender through SimpleMailMessage (Only text data in message)
//	@Override
//	public String addUser(UserDTO userDTO) {
//		try {
//			SimpleMailMessage mail = new SimpleMailMessage();
//			User userToBeAdded = new User();
//			BeanUtils.copyProperties(userDTO, userToBeAdded);
//			userToBeAdded.setAuthStatus(AuthStatus.UNAUTHORIZED);
////			userToBeAdded.setRole(Role.PASSENGER);
//			userRepo.save(userToBeAdded);
//			mail.setTo(userToBeAdded.getEmail());
//			mail.setFrom(fromEmail);
//			mail.setSubject(subject);
//			mail.setText(text);
//			javaMailSender.send(mail);
//			return "User added successfully with id = " + userToBeAdded.getId();
//		} catch (MailException e) {
//			e.printStackTrace();
//			throw new MailHandlingException("Error in adding user or sending mail ");
//		}
//	}

//	java mail sender through MimeMessage (Both text and html data in message)
	@Override
	public String addUser(UserDTO userDTO) {
		try {
			//MimeMessage message = javaMailSender.createMimeMessage();
			//MimeMessageHelper helper = new MimeMessageHelper(message, true);
			User userToBeAdded = new User();
			BeanUtils.copyProperties(userDTO, userToBeAdded);
			userToBeAdded.setAuthStatus(AuthStatus.UNAUTHORIZED);
			userToBeAdded.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
			System.out.println(userToBeAdded.toString());
			User userAdded = userRepo.save(userToBeAdded);
			//helper.setTo(userToBeAdded.getEmail());
			//helper.setFrom(fromEmail);
			//helper.setSubject(subject);
			String finalText = text1+userAdded.getId()+text2; 
			//helper.setText(finalText, true);
			//javaMailSender.send(message);
			return "User added successfully with id = " + userToBeAdded.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailHandlingException("Error in adding user or sending mail ");
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		System.out.println("in loadUserByUsername : "+user);
		if (user == null)
			throw new UserHandlingException("User not found with email : "+email);
//		return new CustomUserDetails(user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public String changePassword(ChangePasswordDTO passwordDTO, Integer uId) {
		User user = userRepo.findById(uId).orElseThrow(() -> new UserHandlingException("Invalid user id"));
		passwordDTO.setOldPassword(bcryptEncoder.encode(passwordDTO.getOldPassword()));
		boolean matches = bcryptEncoder.matches(passwordDTO.getOldPassword(), user.getPassword());
		if(matches) {
			System.out.println("user : " + user);
			user.setPassword(bcryptEncoder.encode(passwordDTO.getNewPassword()));
			return "Password changed successfully...";	
		}
		return "Password doesn't match...";
	}

	@Override
	public String editProfile(Integer uId, UserDTO userdto) {
		try {
			User user = userRepo.findById(uId).get();
			System.out.println("user data fetched " + user);
			BeanUtils.copyProperties(userdto, user, "email", "role");
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			return "Edit profile succeeded...";
		} catch (BeansException e) {
			e.printStackTrace();
			throw new UserHandlingException("Copying failed");
		}
	}

	@Override
	public String deleteAccount(Integer aId) {
		try {
			userRepo.deleteById(aId);
			return "Account Deleted Successfully!!";
		} catch (BeansException e) {
			throw new UserHandlingException("Invalid user Id!!");
		}
	}

	@Override
	public String authorizeUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserHandlingException("Invalid user id..."));
		user.setAuthStatus(AuthStatus.AUTHORIZED);
		return "User with " + userId + "authorization successful...";
	}
	
	@Override
	public ViewProfileDTO getUserDetails(Integer userId) {
		ViewProfileDTO viewProfileDTO = new ViewProfileDTO();
		User user = userRepo.findById(userId).orElseThrow(() -> new UserHandlingException("Invalid user id..."));
		BeanUtils.copyProperties(user, viewProfileDTO, "id", "password");
		return viewProfileDTO;
		
	}

}
