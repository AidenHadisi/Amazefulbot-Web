/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Command;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;
public interface CommandsService {
    Command[] findAllByChannelId(int channelId);
    Command enableCommand(@Valid Command command, boolean value);
    Command updateCommand(Command command);
    Optional<Command> findCommandById(String id);
}
