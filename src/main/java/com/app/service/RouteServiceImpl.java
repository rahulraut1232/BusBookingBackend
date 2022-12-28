package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excs.RouteHandlingException;
import com.app.dao.RouteRepository;
import com.app.dto.AddRouteDTO;
import com.app.pojos.Route;

//service layer class to define route related methods

@Service
@Transactional
public class RouteServiceImpl implements IRouteService {
	@Autowired
	private RouteRepository routeRepo;
	
	@Override
	public Route addRoute(AddRouteDTO route) {
		try {
			System.out.println(route);
			Route routeToBeAdded = new Route();
			BeanUtils.copyProperties(route, routeToBeAdded);
			return routeRepo.save(routeToBeAdded);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new RouteHandlingException("Copying failed");
		} 
	}

	@Override
	public List<Route> getAllRoutes() {
		return routeRepo.findAll();
	}
	
	

}
