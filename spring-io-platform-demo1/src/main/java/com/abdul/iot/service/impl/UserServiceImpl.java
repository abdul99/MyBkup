/**
 * 
 */
package com.abdul.iot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.iot.dao.UserDao;
import com.abdul.iot.model.UserDetails;
import com.abdul.iot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public List<UserDetails> getUserDetails() {
		return (List<UserDetails>) userDao.findAll();
	}

	public UserDetails findById(Long id) {
		return  userDao.findOne(id);
	}

	 
	public UserDetails save(UserDetails user) {
		return  userDao.save(user);
	}

	 
	public UserDetails findByEmail(String email) {
		return  userDao.findByEmail(email);
	}

	 
	public void delete(Long id) {
		userDao.delete(id);
	}
}
