package com.app.dto;

import java.io.Serializable;

import com.app.pojos.User;

public class JwtDTO implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private User user;
	private final String jwttoken;

	public JwtDTO(User user, String jwttoken) {
		this.user = user;
		this.jwttoken = jwttoken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return this.jwttoken;
	}

	@Override
	public String toString() {
		return "JwtDTO [user=" + user + ", jwttoken=" + jwttoken + "]";
	}
	
	
}