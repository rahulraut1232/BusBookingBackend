package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Role;
import com.app.service.UserServiceImpl;

//rest controller for all requests related to owner

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "*")
class OwnerController {

	@Autowired
	private UserServiceImpl userService;

//	add manager request
	@PostMapping("/add-manager")
	public ResponseEntity<?> addManager(@Valid @RequestBody UserDTO manager, BindingResult br) {
		System.out.println("Is Added " + manager);
		if (br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		manager.setRole(Role.MANAGER);
		return new ResponseEntity<>(userService.addUser(manager), HttpStatus.CREATED);
	}
}