/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Alerts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlertsRepository extends MongoRepository<Alerts, String> {
    Optional<Alerts> findByChannelId(int channelId);
}
