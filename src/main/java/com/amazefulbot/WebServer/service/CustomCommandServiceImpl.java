/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.CustomCommand;
import com.amazefulbot.WebServer.repository.CustomCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class CustomCommandServiceImpl implements CustomCommandService {

    @Autowired
    private CustomCommandRepository customCommandRepository;


    @Override
    public CustomCommand[] findAllByChannelId(int channelId) {
        return customCommandRepository.findAllByChannelId(channelId);
    }


    @Override
    public CustomCommand enableCommand(@Valid CustomCommand command, boolean value) {
        command.setEnabled(value);
        return customCommandRepository.save(command);
    }

    @Override
    public CustomCommand updateCommand(CustomCommand command) {
        return customCommandRepository.save(command);
    }

    @Override
    public CustomCommand createCommand(@Valid CustomCommand command) {
        return customCommandRepository.save(command);
    }

    @Override
    public String deleteCommand(@Valid CustomCommand command) {
        customCommandRepository.delete(command);
        return command.getId();
    }

    @Override
    public Optional<CustomCommand> findCommandById(String id) {
        return customCommandRepository.findById(id);
    }

}
