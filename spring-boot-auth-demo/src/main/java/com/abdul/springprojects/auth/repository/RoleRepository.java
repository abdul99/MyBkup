package com.abdul.springprojects.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.springprojects.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
