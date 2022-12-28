package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Bus;
import com.app.pojos.BusSchedule;

//dao layer interface to handle all bus related requests

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{
	
//	method to fetch list of buses for given source and destination
	@Query("select b from Bus b join fetch b.route where b.route.source=:source and b.route.destination=:dest ")
	public List<Bus> fetchBuses(@Param("source") String source, @Param("dest") String destination);
	
//	finder method to find bus schedules for given route and departure time
	@Query("select bs from BusSchedule bs join fetch bs.route where bs.route.id =:route and Date(bs.deptTime)=Date(:dateOfJourney)")
	//BusSchedule findByRouteAndDeptTime(@Param("route") int route, @Param("dateOfJourney") LocalDate dateOfJourney);
	public Optional<BusSchedule> findByRouteAndDeptTime(@Param("route") int route, @Param("dateOfJourney") LocalDate dateOfJourney);
	
//	finder method to find bus by given id
	public Optional<Bus> findById(Integer id);

//	method to check seat availability of bus
	@Query("select (b.totalSeats - b.bookedSeats) as avSeats from Bus b where b.id=:id")
	public Integer checkAvailability(@Param("id") Integer busId);
}
