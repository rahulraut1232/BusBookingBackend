package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.ViewBookingDTO;
import com.app.pojos.Booking;

//dao layer interface to handle all booking related requests

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
//	finder method to fetch booking using id
	public Optional<Booking> findById(Integer bId);

//	method to fetch bookings using user id
	@Query("select b from Booking b where b.user.id =:id")
	public List<Booking> myBookings(@Param("id") int userId);

//	method to fetch bookings using bus id
	@Query("select b from Booking  b")
	public List<Booking> viewAllBookings();
}
