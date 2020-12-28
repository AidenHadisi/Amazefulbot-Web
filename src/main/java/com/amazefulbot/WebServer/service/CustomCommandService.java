/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.CustomCommand;

import javax.validation.Valid;
import java.util.Optional;

public interface CustomCommandService {
    CustomCommand[] findAllByChannelId(int channelId);
    CustomCommand enableCommand(@Valid CustomCommand command, boolean value);
    CustomCommand updateCommand(CustomCommand command);
    CustomCommand createCommand(@Valid CustomCommand command);
    String deleteCommand(@Valid CustomCommand command);
    Optional<CustomCommand> findCommandById(String id);
}
