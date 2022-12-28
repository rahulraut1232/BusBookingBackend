package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

//DTO layer class to handle view bus request data

public class ViewBusDTO {
	@NotBlank(message = "Source can not be blank")
	private String source;
	@NotBlank(message = "Destination can not be blank")
	private String destination;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;
	
	public ViewBusDTO() {
		// TODO Auto-generated constructor stub
	}

	public ViewBusDTO(String source, String destination, LocalDate dateOfJourney) {
		super();
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
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

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	@Override
	public String toString() {
		return "ViewBus [source=" + source + ", destination=" + destination + ", dateOfJourney=" + dateOfJourney + "]";
	}
	
}
