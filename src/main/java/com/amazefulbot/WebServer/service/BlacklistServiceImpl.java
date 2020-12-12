/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Blacklist;
import com.amazefulbot.WebServer.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Autowired
    private BlacklistRepository blacklistRepository;
    @Override
    public Blacklist[] findAllById(int id) {
        return blacklistRepository.findAllById(id);
    }
}
