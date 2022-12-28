package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BusDTO;
import com.app.dto.ErrorDTO;
import com.app.dto.ViewBusDTO;
import com.app.service.BusServiceImpl;

//rest controller for all requests related to bus

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {

	@Autowired
	private BusServiceImpl busService;

	public BusController() {
		System.out.println("in constructor of " + getClass().getName());
	}

//	method to handle view bus request
	@PostMapping("/view-bus")
	public ResponseEntity<?> viewBus(@Valid @RequestBody ViewBusDTO vb, BindingResult br) {
		System.out.println("in view bus " + vb);
		if (br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(busService.fetchBuses(vb.getSource(), vb.getDestination(), vb.getDateOfJourney()), HttpStatus.OK); //
	}

//	add bus request
	@PostMapping("/add-bus")
	public ResponseEntity<?> addBus(@Valid @RequestBody BusDTO busDTO, BindingResult br) {
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(busService.addBus(busDTO), HttpStatus.OK);
	}

//	check seat availability request
	@GetMapping("/check-availability/{busId}")
	public ResponseEntity<?> checkAvailability(@PathVariable Integer busId) {
		System.out.println("in check availability, busid : " + busId);
		return new ResponseEntity<>(busService.checkAvailability(busId), HttpStatus.OK);
	}
	
//	@GetMapping("/check-seat-status/{busId}")
//	public ResponseEntity<?> checkSeatStatus(@PathVariable Integer busId) {
//		System.out.println("in check seat status, busid : " + busId);
//		return new ResponseEntity<>(busService.getSeatStatus(busId), HttpStatus.OK);
//	}

}