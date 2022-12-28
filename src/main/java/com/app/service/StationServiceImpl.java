package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excs.StationHandlingException;
import com.app.dao.StationRepository;
import com.app.pojos.Station;

//service layer class to define station related methods

@Service
@Transactional
public class StationServiceImpl implements IStationService {
	@Autowired
	private StationRepository stationRepo;
	
	@Override
	public Station getStation(Integer stationId) {
		return stationRepo.findById(stationId).orElseThrow(() -> new StationHandlingException("Station not found..."));
	}

	
}
