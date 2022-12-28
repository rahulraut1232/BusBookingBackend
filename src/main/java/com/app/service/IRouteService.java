package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.AddRouteDTO;
import com.app.pojos.Route;

//service layer interface to declare route related methods

public interface IRouteService {
	
//	method to add new route
	public Route addRoute(AddRouteDTO route);
	
//	method to get all routes
	public List<Route> getAllRoutes();
	
}
