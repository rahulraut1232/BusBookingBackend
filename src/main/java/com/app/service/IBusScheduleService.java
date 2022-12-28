package com.app.service;

import com.app.dto.BusScheduleDTO;
import com.app.dto.BusScheduleResponse;

public interface IBusScheduleService {
	
//	method to add bus schedule
	public String addBusSchedule(BusScheduleDTO busSchedule);
	
//	method to get bus schedule
	public BusScheduleResponse getScheduleDetails();
}
