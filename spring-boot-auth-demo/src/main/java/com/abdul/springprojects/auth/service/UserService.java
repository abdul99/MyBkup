package com.abdul.springprojects.auth.service;

import com.abdul.springprojects.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
