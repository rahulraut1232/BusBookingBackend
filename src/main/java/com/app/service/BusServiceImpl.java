package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excs.BookingHandlingException;
import com.app.custom_excs.BusHandlingException;
import com.app.dao.BusRepository;
import com.app.dao.BusScheduleRepository;
import com.app.dao.RouteRepository;
import com.app.dto.BusDTO;
import com.app.dto.BusList;
import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;
import com.app.pojos.Route;

//service layer class to define bus related methods

@Service
@Transactional
public class BusServiceImpl implements IBusService {

	@Autowired
	private BusRepository busRepo;
	@Autowired
	private RouteRepository routeRepo;
	@Autowired
	private BusScheduleRepository busScheduleRepo;

//	@Override
//	public List<Bus> fetchBuses(String source, String destination, LocalDate dateOfJourney) {
//
//		try {
//			List<Bus> buses = busRepo.fetchBuses(source, destination);
//			System.out.println("buses " + buses);
//			List<BusSchedule> busScheduleList = new ArrayList<BusSchedule>();
//			List<Bus> busesList = new ArrayList<Bus>();
//			for (Bus b : buses) {
//				int route_id = b.getRoute().getId();
//				busScheduleList.add(busRepo.findByRouteAndDeptTime(route_id, dateOfJourney).get());
//			}
//			System.out.println("busScheduleList " + busScheduleList);
//			for (BusSchedule bs : busScheduleList) {
//				int bus_id = bs.getBus().getId();
//				busesList.add(busRepo.findById(bus_id).get());
//			}
//			System.out.println("busesList " + busesList);
//			return busesList;
//		} catch (RuntimeException e) {
//			throw new BusHandlingException("List is empty!!");
//		}
//	}

	@Override
	public List<BusSchedule> fetchBuses(String source, String destination, LocalDate dateOfJourney){    //) {
		Route route = routeRepo.findBySourceAndDestination(source, destination).get();
		List<BusSchedule> busSchedules = busScheduleRepo.findByRoute(route);
		List<BusSchedule> response = new ArrayList<>();
		for (BusSchedule busSchedule : busSchedules) {
			//if(busSchedule.getDeptTime().toLocalDate().isAfter(dateOfJourney))
				response.add(busSchedule); 
		}
		return response;
	}

	@Override
	public String addBus(BusDTO busDTO) {
		try {
			Bus bus = new Bus();
			BeanUtils.copyProperties(busDTO, bus);
			busRepo.save(bus);
			return "Bus added with id = "+bus.getId();
		} catch (BeansException e) {
			e.printStackTrace();
			throw new BusHandlingException("Copying failed");
		}
	}


	@Override
	public int checkAvailability(int busId) {
		try {
			return busRepo.checkAvailability(busId);
		} catch (Exception e) {
			throw new BookingHandlingException("Invalid Bus Id!!");
		}
	}

//	@Override
//	public boolean[] getSeatStatus(int busId) {
//		Bus bus = busRepo.findById(busId).get();
//		System.out.println("seats : "+bus.toString());
//		return bus.getSeats();
//	}

}
