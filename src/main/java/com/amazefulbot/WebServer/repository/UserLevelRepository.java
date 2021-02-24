/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.UserLevel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLevelRepository extends MongoRepository<UserLevel, String> {
    Optional<UserLevel> findByChannelId(int channelId);
}
