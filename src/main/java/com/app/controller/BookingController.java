package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingDTO;
import com.app.dto.ErrorDTO;
import com.app.service.BookingServiceImpl;

//DTO layer class to add route to application

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "*")
public class BookingController {
	@Autowired
	private BookingServiceImpl bookingService;

//	add booking request
	@PostMapping("/add-booking")
	public ResponseEntity<?> addBooking(@Valid @RequestBody BookingDTO booking, BindingResult br){
		System.out.println("in add booking "+booking);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		System.out.println(bookingService.addBooking(booking));
		return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.CREATED);
	}
	
//	delete booking request
	@DeleteMapping("/cancel-booking/{bId}")
	public ResponseEntity<?> cancelBooking(@PathVariable Integer bId) {
		System.out.println("in cancel booking, bid : " + bId);
		return new ResponseEntity<>(bookingService.cancelBooking(bId), HttpStatus.OK);
	}

//	check reservation request
	@GetMapping("/check-reservation/{bId}")
	public ResponseEntity<?> checkReservation(@PathVariable Integer bId) {
		System.out.println("in check reservation, bid : " + bId);
		return new ResponseEntity<>(bookingService.checkReservation(bId), HttpStatus.OK);
	}
	
//	show user bookings request
	@GetMapping("/my-bookings/{userId}")
	public ResponseEntity<?> myBookings(@PathVariable int userId){
	System.out.println("in mybookings"+userId);
	return new ResponseEntity<>(bookingService.myBookings(userId), HttpStatus.OK);	
	}
	
//	view all bookings of bus
	
	@GetMapping("/view-bookings/")
	public ResponseEntity<?> viewAllBookings(){
		System.out.println("in view all bookings, busId : ");
		return new ResponseEntity<>(bookingService.viewAllBookings(), HttpStatus.OK);
	}
}
