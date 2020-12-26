package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Commands;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandsRepository extends MongoRepository<Commands, String> {
    @Query(value = " {'minimumRole' : {$lt: 900}}", sort = "{ 'name': 1 }")
    Commands[] findAllByChannelId(int channelId);
}
