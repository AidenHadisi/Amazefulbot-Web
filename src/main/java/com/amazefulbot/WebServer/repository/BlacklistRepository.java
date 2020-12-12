/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Blacklist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends MongoRepository<Blacklist, String> {
    Blacklist[] findAllById(int id);
}
