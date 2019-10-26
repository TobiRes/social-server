package com.social.server.repositories;

import com.social.server.models.user.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findFirstByid(String id);
}