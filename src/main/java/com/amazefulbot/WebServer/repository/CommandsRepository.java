package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Command;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandsRepository extends MongoRepository<Command, String> {
    @Query(value = " {'minimumRole' : {$lt: 900}}", sort = "{ 'name': 1 }")
    Command[] findAllByChannelId(int channelId);
    Command findOneByidAndChannelId(String id, int channelId);
}
