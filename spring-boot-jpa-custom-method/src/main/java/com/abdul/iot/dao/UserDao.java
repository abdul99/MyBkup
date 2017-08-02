package com.abdul.iot.dao;

import org.springframework.data.repository.CrudRepository;

import com.abdul.iot.model.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Long> {
	
	UserDetails findByEmail(String email);
	
}
