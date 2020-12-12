package com.amazefulbot.WebServer.publicAPI.repository;

import com.amazefulbot.WebServer.publicAPI.models.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicChannelRepository extends MongoRepository<Channel, String> {
    Optional<Channel> getByChannelId(int channelId);
    Optional<Channel> getByLogin(String login);
}
