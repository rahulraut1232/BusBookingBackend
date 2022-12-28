package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Route;

//dao layer interface to handle all routes related requests

public interface RouteRepository extends JpaRepository<Route, Integer>{

//	method to find route using id
	public Optional<Route> findById(Integer routeId);
	
//	method to find route using source and destination
	public Optional<Route> findBySourceAndDestination(String source, String destination);

}
