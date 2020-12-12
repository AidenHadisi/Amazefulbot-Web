/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Commands;

public interface CommandsService {
    Commands[] findAllByChannelId(int channelId);
}
