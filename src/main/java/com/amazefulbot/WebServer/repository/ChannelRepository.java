package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChannelRepository extends MongoRepository<Channel, String> {
    Channel findById(int channelId);
    Channel findByLogin(String login);
    Optional<Channel> getByObjId(String id);
}
