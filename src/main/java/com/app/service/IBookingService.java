package com.app.service;

import java.util.List;

import com.app.dto.BookingDTO;
import com.app.dto.BookingResponseDTO;
import com.app.dto.ViewBookingDTO;
import com.app.pojos.Booking;

//service layer interface to declare booking related methods

public interface IBookingService {
	
//	method to add new booking
	public Booking addBooking(BookingDTO booking);
	
//	method to cancel booking
	public String cancelBooking(Integer bId);
	
//	method to check reservation for booking
	public ViewBookingDTO checkReservation(Integer bId);
	
//	method to show all bookings of user
	public List<Booking> myBookings(int userId);
	
//	method to show all bookings of bus
	public List<ViewBookingDTO> viewAllBookings(int busId);

	public List<ViewBookingDTO> viewAllBookings();
}
