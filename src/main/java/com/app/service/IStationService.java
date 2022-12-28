package com.app.service;

import com.app.pojos.Station;

//service layer interface to declare station related methods

public interface IStationService {
	
//	method to find station using id
	public Station getStation(Integer stationId);
}
