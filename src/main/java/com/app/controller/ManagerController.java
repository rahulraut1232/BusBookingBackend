package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BusScheduleDTO;
import com.app.dto.ErrorDTO;
import com.app.dto.UserDTO;
import com.app.pojos.BusSchedule;
import com.app.pojos.Role;
import com.app.service.BusScheduleServiceImpl;
import com.app.service.UserServiceImpl;

//rest controller for all requests related to manager

@RestController
@RequestMapping("/manager")
@CrossOrigin(origins = "*")
class ManagerController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BusScheduleServiceImpl busScheduleService;

//	add agent request
	@PostMapping("/add-agent")
	public ResponseEntity<?> addAgent(@Valid @RequestBody UserDTO agent, BindingResult br) {
		System.out.println("Is Added " + agent);
		if (br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		agent.setRole(Role.AGENT);
		return new ResponseEntity<>(userService.addUser(agent), HttpStatus.CREATED);
	}

//	add driver request
	@PostMapping("/add-driver")
	public ResponseEntity<?> addDriver(@Valid @RequestBody UserDTO driver, BindingResult br) {
		System.out.println("Is Added " + driver);
		if (br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		driver.setRole(Role.DRIVER);
		return new ResponseEntity<>(userService.addUser(driver), HttpStatus.CREATED);
	}
	
	@GetMapping("/get-schedule-details")
	public ResponseEntity<?> getScheduleDetails(){
		System.out.println("in get schedule details ");
		return new ResponseEntity<>(busScheduleService.getScheduleDetails(), HttpStatus.OK);
	}
	
	@PostMapping("/add-schedule")
	public ResponseEntity<?> addSchedule(@RequestBody BusScheduleDTO busSchedule){
		System.out.println("in bus schedule "+busSchedule);
		return new ResponseEntity<>(busScheduleService.addBusSchedule(busSchedule), HttpStatus.OK);
	}
}
