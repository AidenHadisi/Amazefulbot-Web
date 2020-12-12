package com.amazefulbot.WebServer.publicAPI.repository;

import com.amazefulbot.WebServer.publicAPI.models.CustomCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicCustomCommandsRepository extends MongoRepository<CustomCommand, String> {
    CustomCommand[] getByChannelId(int channelId);
}
