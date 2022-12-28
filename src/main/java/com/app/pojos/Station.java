package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//pojo layer class for user station

@Entity
@Table(name= "stations")
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String stationName;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "stations")
	@JsonIgnore
	private List<Bus> buses = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(Integer id, String stationName, Route route) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.route = route;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public List<Bus> getBusList() {
		return buses;
	}

	public void setBusList(List<Bus> busList) {
		this.buses = busList;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationName=" + stationName + "]";
	}
	
}
