package com.amazefulbot.WebServer.publicAPI.repository;

import com.amazefulbot.WebServer.publicAPI.models.Commands;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicCommandsRepository extends MongoRepository<Commands, String> {
    Commands[] findByChannelId(int channelId);
}
