package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.CustomCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCommandRepository extends MongoRepository<CustomCommand, String> {
    CustomCommand[] findAllByChannelId(int channelId);
}
