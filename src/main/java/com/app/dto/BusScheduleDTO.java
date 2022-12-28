package com.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class BusScheduleDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime arrivalTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime deptTime;
	private int routeId;
	private int busId;
	
	public BusScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public BusScheduleDTO(LocalDateTime arrivalTime, LocalDateTime deptTime, int routeId, int busId) {
		super();
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.routeId = routeId;
		this.busId = busId;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(LocalDateTime deptTime) {
		this.deptTime = deptTime;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "BusScheduleDTO [arrivalTime=" + arrivalTime + ", deptTime=" + deptTime + ", routeId=" + routeId
				+ ", busId=" + busId + "]";
	}
	
	
}
