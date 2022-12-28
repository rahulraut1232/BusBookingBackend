package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.BookingType;

public class ViewBookingDTO {
	private int id;
	private String busName;
	private String busType;
	private LocalDate dateOfJourney;
	private LocalDate dateOfBooking;
	private BookingType bookType;
	private int seatNumber;
	private double fare;
	
	public ViewBookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public ViewBookingDTO(int id,String busName, String busType, LocalDate dateOfJourney, LocalDate dateOfBooking, BookingType bookType,
			int seatNumber, double fare) {
		super();
		this.id = id;
		this.busName = busName;
		this.busType = busType;
		this.dateOfJourney = dateOfJourney;
		this.dateOfBooking = dateOfBooking;
		this.bookType = bookType;
		this.seatNumber = seatNumber;
		this.fare = fare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public BookingType getBookType() {
		return bookType;
	}

	public void setBookType(BookingType bookType) {
		this.bookType = bookType;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "ViewBookingDTO [id=" + id + ", dateOfJourney=" + dateOfJourney + ", dateOfBooking=" + dateOfBooking
				+ ", bookType=" + bookType + ", seatNumber=" + seatNumber + ", fare=" + fare + "]";
	}
	

}
