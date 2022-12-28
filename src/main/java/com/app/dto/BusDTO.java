package com.app.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BusDTO {
	//@NotBlank(message = "Bus name can not be blank")
	private String busName;
	//@NotBlank(message = "Bus type can not be blank")
	private String busType;
	//@NotBlank(message = "Bus number can not be blank")
	//@Pattern(regexp="^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$\r\n", message = "Inappropriate vehicle number")
	private String busNumber;
	//@NotBlank(message = "Total seats can not be blank")
	private int totalSeats;
	private boolean seats[];

	public BusDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BusDTO(String busName, String busType, String busNumber, int totalSeats, boolean[] seats) {
		super();
		this.busName = busName;
		this.busType = busType;
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.seats = seats;
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

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public boolean[] getSeats() {
		return seats;
	}

	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "BusDTO [busName=" + busName + ", busType=" + busType + ", busNumber=" + busNumber + ", totalSeats="
				+ totalSeats + ", seats=" + Arrays.toString(seats) + "]";
	}
	
}

	