/**
 * 
 */
package com.abdul.iot.service;

import java.util.List;

import com.abdul.iot.model.UserDetails;

public interface UserService {

	List<UserDetails> getUserDetails();

	UserDetails findById(Long id);

	UserDetails save(UserDetails user);

	UserDetails findByEmail(String email);

	void delete(Long id);
}
