package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//pojo layer class for user bus schedules

@Entity
@Table(name = "bus_schedule")
public class BusSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime arrivalTime;
	private LocalDateTime deptTime;
	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;
	@OneToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	public BusSchedule() {
		// TODO Auto-generated constructor stub
	}

	public BusSchedule(Integer id, LocalDateTime arrivalTime, LocalDateTime deptTime, Route route, Bus bus) {
		super();
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.route = route;
		this.bus = bus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusSchedule [id=" + id + ", arrivalTime=" + arrivalTime + ", deptTime=" + deptTime + "]";
	}
	
	

}
