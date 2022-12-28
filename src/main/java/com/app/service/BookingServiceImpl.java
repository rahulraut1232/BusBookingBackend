package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excs.BookingHandlingException;
import com.app.dao.BookingRepository;
import com.app.dao.BusRepository;
import com.app.dao.RouteRepository;
import com.app.dao.StationRepository;
import com.app.dao.UserRepository;
import com.app.dto.BookingDTO;
import com.app.dto.BookingResponseDTO;
import com.app.dto.ViewBookingDTO;
import com.app.pojos.Booking;
import com.app.pojos.BookingStatus;
import com.app.pojos.BookingType;
import com.app.pojos.Bus;
import com.app.pojos.Route;

//service layer class to define booking related methods

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {
	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private BusRepository busRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private StationRepository stationRepo;
	@Autowired
	private RouteRepository routeRepo;


	@Override
	public Booking addBooking(BookingDTO booking) {
		Booking bookingToBeAdded = new Booking();
		BeanUtils.copyProperties(booking, bookingToBeAdded);
		if (bookingToBeAdded.getBookType().equals(BookingType.CARGO)) {
			bookingToBeAdded.setSeatNumber(0);
		}
		Bus bus = busRepo.findById(booking.getBusId()).get();
		bookingToBeAdded.setBus(bus);
		//bookingToBeAdded.setBoardingStation(stationRepo.findById(booking.getBoardingStation()).get());
		//bookingToBeAdded.setDroppingStation(stationRepo.findById(booking.getDroppingStation()).get());
		bookingToBeAdded.setUser(userRepo.findById(booking.getUserId()).get());
		bookingToBeAdded.setRoute(bus.getRoute());
		bookingToBeAdded.setBookingStatus(BookingStatus.PENDING);
		bookingToBeAdded.setDateOfBooking(LocalDate.now());
		bookingToBeAdded.setFare(500);
		return bookingRepo.save(bookingToBeAdded);
	}

	@Override
	public String cancelBooking(Integer bId) {
		try {
			bookingRepo.deleteById(bId);
			return "Booking Cancelled Successfully!!";
		} catch (IllegalArgumentException e) {
			throw new BookingHandlingException("Invalid Booking Id!!");
		}
	}

	@Override
	public ViewBookingDTO checkReservation(Integer bId) {
			ViewBookingDTO viewBookingDTO = new ViewBookingDTO();
			Booking booking = bookingRepo.findById(bId).orElseThrow(() -> new BookingHandlingException("Invalid Booking Id!!"));
			BeanUtils.copyProperties(booking, viewBookingDTO);
			return viewBookingDTO;
	}

	@Override
	public List<Booking> myBookings(int userId) {
		try {
			BookingResponseDTO bookingResponse = new BookingResponseDTO();
			List<BookingResponseDTO> bookings = new ArrayList<>();
			List<Booking> myBookings = bookingRepo.myBookings(userId);
			for (Booking booking : myBookings) {
				bookingResponse.setDateOfJourney(booking.getDateOfJourney());
				Route route = routeRepo.findById(booking.getRoute().getId()).get();
				Bus bus = busRepo.findById(booking.getBus().getId()).get();
				bookingResponse.setSource(route.getSource());
				bookingResponse.setDestination(route.getDestination());
				//bookingResponse.setBoarding(stationRepo.findById(booking.getBoardingStation().getId()).get().getStationName());
				bookingResponse.setBusName(bus.getBusName());
				bookingResponse.setBusType(bus.getBusType());
				bookingResponse.setId(booking.getId());
				bookingResponse.setSeatNumber(booking.getSeatNumber());
				System.out.println(booking.getSeatNumber());
				bookings.add(bookingResponse);
				//System.out.println(bookingResponse);
			}
			for(Booking  x: myBookings) {
				System.out.println(x);
			}
			return myBookings;
		} catch (Exception e) {
			throw new BookingHandlingException("Invalid User Id!!");
		}
	}
	@Override
	public List<ViewBookingDTO> viewAllBookings() {
		try {
			List<ViewBookingDTO> viewBookingDTOList = new ArrayList<>();
			List<Booking> bookingList = bookingRepo.viewAllBookings();
			for(Booking b : bookingList) {
					ViewBookingDTO d = new ViewBookingDTO();
					BeanUtils.copyProperties(b, d);
					viewBookingDTOList.add(d);
			}
			return viewBookingDTOList;
		} catch (Exception e) {
			throw new BookingHandlingException("Invalid Bus Id!!");
		}
	}

	@Override
	public List<ViewBookingDTO> viewAllBookings(int busId) {
		// TODO Auto-generated method stub
		return null;
	}
}
