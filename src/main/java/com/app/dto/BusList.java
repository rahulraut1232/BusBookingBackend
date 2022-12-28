package com.app.dto;

import java.util.List;

import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;
import com.app.pojos.Route;

public class BusList {
	private List<BusSchedule> busSchedules;
	private List<Bus> buses;
	private Route route;
	
	public BusList() {
		// TODO Auto-generated constructor stub
	}

	public BusList(List<BusSchedule> busSchedules, List<Bus> buses, Route route) {
		super();
		this.busSchedules = busSchedules;
		this.buses = buses;
		this.route = route;
	}

	public List<BusSchedule> getBusSchedules() {
		return busSchedules;
	}

	public void setBusSchedules(List<BusSchedule> busSchedules) {
		this.busSchedules = busSchedules;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "BusList [busSchedules=" + busSchedules + ", buses=" + buses + ", route=" + route + "]";
	}

}
