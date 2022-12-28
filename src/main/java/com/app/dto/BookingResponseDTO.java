package com.app.dto;

import java.time.LocalDate;

public class BookingResponseDTO {
	private int id;
	private String source;
	private String destination;
	private String boarding;
	private LocalDate dateOfJourney;
	private String busName;
	private String busType;
	private int seatNumber;
	
	public BookingResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookingResponseDTO(String source, String destination, String boarding, LocalDate dateOfJourney,
			String busName, String busType, int seatNumber) {
		super();
		this.source = source;
		this.destination = destination;
		this.boarding = boarding;
		this.dateOfJourney = dateOfJourney;
		this.busName = busName;
		this.busType = busType;
		this.seatNumber = seatNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
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

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "BookingResponseDTO [source=" + source + ", destination=" + destination + ", boarding=" + boarding
				+ ", dateOfJourney=" + dateOfJourney + ", busName=" + busName + ", busType=" + busType + "seatNumber"+seatNumber+ "]";
	}

	
}
