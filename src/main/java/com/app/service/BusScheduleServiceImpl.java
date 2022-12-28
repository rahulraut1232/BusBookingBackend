package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BusRepository;
import com.app.dao.BusScheduleRepository;
import com.app.dao.RouteRepository;
import com.app.dto.BusScheduleDTO;
import com.app.dto.BusScheduleResponse;
import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;
import com.app.pojos.Route;

@Service
@Transactional
public class BusScheduleServiceImpl implements IBusScheduleService {
	@Autowired
	private BusScheduleRepository busScheduleRepo;
	@Autowired
	private RouteRepository routeRepo;
	@Autowired
	private BusRepository busRepo;

	@Override
	public String addBusSchedule(BusScheduleDTO busSchedule) {
		Bus bus = busRepo.findById(busSchedule.getBusId()).get();
		Route route = routeRepo.findById(busSchedule.getRouteId()).get();
		bus.setRoute(route);
		BusSchedule busScheduleToBeAdded = new BusSchedule();
		busScheduleToBeAdded.setArrivalTime(busSchedule.getArrivalTime());
		busScheduleToBeAdded.setDeptTime(busSchedule.getDeptTime());
		busScheduleToBeAdded.setBus(bus);
		busScheduleToBeAdded.setRoute(route);
		busScheduleRepo.save(busScheduleToBeAdded);
		return "Bus Schedule added";
	}

	@Override
	public BusScheduleResponse getScheduleDetails() {
		List<Bus> buses = new ArrayList<>();
		List<Route> routes = new ArrayList<>();
		buses = busRepo.findAll();
		routes = routeRepo.findAll();
		return new BusScheduleResponse(buses, routes);
	}
	
	
	
}
