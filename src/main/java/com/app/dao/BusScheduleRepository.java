package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;
import com.app.pojos.Route;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Integer> {
	
//	method to find bus schedule using route
	public List<BusSchedule> findByRoute(Route route);
	
}
