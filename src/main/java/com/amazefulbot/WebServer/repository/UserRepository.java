package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(int userId);
    User findByLogin(String login);

    User findById(ObjectId objectId);
    User findByObjId(String id);

}
