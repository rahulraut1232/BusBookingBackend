package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//pojo layer class for user route

@Entity
@Table(name= "routes")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String source;
	@Column(length = 30)
	private String destination;
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Station> stations = new ArrayList<>();
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Bus> buses = new ArrayList<>();
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Booking> bookings = new ArrayList<>();

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public Route(Integer id, String source, String destination) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}
	
	
}
