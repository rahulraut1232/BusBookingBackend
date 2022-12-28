package com.app.dto;

import javax.validation.constraints.NotBlank;

//DTO layer class to add route to application

public class AddRouteDTO {
	@NotBlank(message = "Source can not be blank")
	private String source;
	@NotBlank(message = "Destination can not be blank")
	private String destination;
	
	public AddRouteDTO() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public AddRouteDTO(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "AddRouteDTO [source=" + source + ", destination=" + destination + "]";
	}
	
}
