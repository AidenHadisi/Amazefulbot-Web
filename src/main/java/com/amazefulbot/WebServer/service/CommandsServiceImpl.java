/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Command;
import com.amazefulbot.WebServer.repository.CommandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import java.util.Optional;

@Service
@Validated
public class CommandsServiceImpl implements CommandsService {
    @Autowired
    private CommandsRepository commandsRepository;


    @Override
    public Command[] findAllByChannelId(int channelId) {
        return commandsRepository.findAllByChannelId(channelId);
    }



    @Override
    public Command enableCommand(@Valid Command command, boolean value) {
        command.setEnabled(value);
        return commandsRepository.save(command);
    }

    @Override
    public Command updateCommand(Command command) {
        return commandsRepository.save(command);
    }

    @Override
    public Optional<Command> findCommandById(String id) {
        return commandsRepository.findById(id);
    }


}
