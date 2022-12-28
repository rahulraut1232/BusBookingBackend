package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//pojo layer class for user bus

@Entity
@Table(name = "buses")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String busName;
	@Column(length = 30)
	private String busType;
	@Column(length = 30, unique = true)
	private String busNumber;
	private int totalSeats;
	private int bookedSeats;
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Booking> bookings = new ArrayList<>();
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "haults", joinColumns = @JoinColumn(name = "bus_id"), inverseJoinColumns = @JoinColumn(name = "station_id"))
	@JsonIgnore
	private List<Station> stations = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(Integer id, String busName, String busType, String busNumber, int totalSeats, int bookedSeats) {
		super();
		this.id = id;
		this.busName = busName;
		this.busType = busType;
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busName=" + busName + ", busType=" + busType + ", busNumber=" + busNumber
				+ ", totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats + "]";
	}
	
}
