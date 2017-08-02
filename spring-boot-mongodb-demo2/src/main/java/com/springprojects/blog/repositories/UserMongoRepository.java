package com.springprojects.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springprojects.blog.domain.User;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
    User findByName(String name);
}
