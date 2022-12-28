package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddRouteDTO;
import com.app.dto.ErrorDTO;
import com.app.pojos.Route;
import com.app.service.RouteServiceImpl;
import com.sun.mail.iap.Response;

//rest controller for all requests related to route

@RestController
@RequestMapping("/route")
@CrossOrigin(origins = "*")
public class RouteController {
	@Autowired
	private RouteServiceImpl routeService;

	public RouteController() {
	System.out.println("in constructor of "+getClass().getName());
	}
	
//	add new route in application
	@PostMapping("/add-route")
	public ResponseEntity<?> addRoute(@Valid @RequestBody AddRouteDTO route, BindingResult br) {
		System.out.println("in add route "+route);
		if(br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Route>(routeService.addRoute(route), HttpStatus.CREATED);
	}
	
//	get all available routes
	@GetMapping("/get-routes")
	public ResponseEntity<?> getRoutes(){
		System.out.println("in get all routes");
		return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);
	}
}
