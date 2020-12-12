package com.amazefulbot.WebServer.publicAPI.repository;


import com.amazefulbot.WebServer.publicAPI.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicUserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(int userId);
    Optional<User> findByLogin(String login);
}

