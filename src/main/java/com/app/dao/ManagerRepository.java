package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

//dao layer interface to handle all manager related requests

public interface ManagerRepository extends JpaRepository<User, Integer> {

}
