package com.abdul.springprojects.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.springprojects.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
