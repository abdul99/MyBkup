package com.abdul.springprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.springprojects.domain.User;

 
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
