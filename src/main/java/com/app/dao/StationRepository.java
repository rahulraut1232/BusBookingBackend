package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Station;

//dao layer interface to handle all routes related requests

public interface StationRepository extends JpaRepository<Station, Integer> {
	
//	finder method to get station from id
	public Optional<Station> findById(Integer id);
}
