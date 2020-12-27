/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Command;
import com.amazefulbot.WebServer.repository.CommandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandsServiceImpl implements CommandsService {
    @Autowired
    private CommandsRepository commandsRepository;

    @Override
    public Command[] findAllByChannelId(int channelId) {
        return commandsRepository.findAllByChannelId(channelId);
    }

    @Override
    public Command updateCommand(Command command) {
        var commandFromDB = commandsRepository.findOneByidAndChannelId(command.getId(), command.getChannelId());
        commandFromDB.setCooldown(command.getCooldown());
        commandFromDB.setUser_cooldown(command.getUser_cooldown());
        commandFromDB.setRole(command.getRole());
        commandFromDB.setStream_status(command.getStream_status());
        return commandsRepository.save(commandFromDB);
    }
}
