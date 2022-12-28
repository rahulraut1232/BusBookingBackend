package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

//dao layer interface to handle all owner related requests

public interface OwnerRepository extends JpaRepository<User, Integer> {

	
}
