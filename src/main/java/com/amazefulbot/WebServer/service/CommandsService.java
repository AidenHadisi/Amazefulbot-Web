/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Command;

public interface CommandsService {
    Command[] findAllByChannelId(int channelId);
    Command updateCommand(Command command);
}
