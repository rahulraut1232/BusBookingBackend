package com.app.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.BookingType;

//DTO layer class to add passenger bookings to application

public class BookingDTO {
	//@NotBlank(message = "User id can not be blank")
	private int userId;
	//@NotBlank(message = "Bus id can not be blank")
	private int busId;
	//@NotBlank(message = "Boarding station can not be blank")
	private int boardingStation;
	//@NotBlank(message = "Dropping station can not be blank")
	private int droppingStation;
	//@NotBlank(message = "Seat number can not be blank")
	//@Min(value = 1)
	//@Max(value = 50)
	private int seatNumber;
	//@NotBlank(message = "Date of journey can not be blank")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;
	//@NotBlank(message = "Book type can not be blank")
	@Enumerated(EnumType.STRING)
	private BookingType bookType;
	
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(int userId, int busId, int boardingStation, int droppingStation, int seatNumber,
			LocalDate dateOfJourney, BookingType bookType) {
		super();
		this.userId = userId;
		this.busId = busId;
		this.boardingStation = boardingStation;
		this.droppingStation = droppingStation;
		this.seatNumber = seatNumber;
		this.dateOfJourney = dateOfJourney;
		this.bookType = bookType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBoardingStation() {
		return boardingStation;
	}

	public void setBoardingStation(int boardingStation) {
		this.boardingStation = boardingStation;
	}

	public int getDroppingStation() {
		return droppingStation;
	}

	public void setDroppingStation(int droppingStation) {
		this.droppingStation = droppingStation;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
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

	@Override
	public String toString() {
		return "BookingDTO [userId=" + userId + ", busId=" + busId + ", boardingStation=" + boardingStation
				+ ", droppingStation=" + droppingStation + ", dateOfJourney=" + dateOfJourney + ", bookType=" + bookType
				+ "]";
	}
	
}
