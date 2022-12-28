package com.app.dto;

import com.app.pojos.Route;

import java.util.List;

import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;

public class BusScheduleResponse {
	private List<Bus> buses;
	private List<Route> routes;
	
	public BusScheduleResponse() {
		// TODO Auto-generated constructor stub
	}

	public BusScheduleResponse(List<Bus> buses, List<Route> routes) {
		super();
		this.buses = buses;
		this.routes = routes;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "BusScheduleResponse [buses=" + buses + ", routes=" + routes + "]";
	}

	
}
