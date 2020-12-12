/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Commands;
import com.amazefulbot.WebServer.repository.CommandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandsServiceImpl implements CommandsService {
    @Autowired
    private CommandsRepository commandsRepository;

    @Override
    public Commands[] findAllByChannelId(int channelId) {
        return commandsRepository.findAllByChannelId(channelId);
    }
}
