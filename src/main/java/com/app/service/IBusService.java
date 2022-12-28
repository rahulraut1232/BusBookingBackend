package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.BusDTO;
import com.app.pojos.BusSchedule;

//service layer interface to declare bus related methods

public interface IBusService {
	
//	method to fetch all buses for given source and destination
	public List<BusSchedule> fetchBuses(String source, String destination, LocalDate dateOfJourney); //

//	method to add new bus
	public String addBus(BusDTO bus);
	
//	method to check seat availability using bus id
	public int checkAvailability(int busId);
	
//	method to check status of seats using bus id
//	public boolean[] getSeatStatus(int busId);
	
}