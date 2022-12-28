package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
//	finder method to find user with given email and password
	public Optional<User> findByEmailAndPassword(String email, String password);
	
//	finder method to find user with given user id
	public Optional<User> findById(Integer uId);
	
//	method to find user by using name
	public User findByName(String name);

//	method to find user by using email
	public User findByEmail(String email);


}
