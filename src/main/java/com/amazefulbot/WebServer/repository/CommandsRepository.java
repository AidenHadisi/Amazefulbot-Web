package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Commands;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandsRepository extends MongoRepository<Commands, String> {
    Commands[] findAllByChannelId(int channelId);
}
