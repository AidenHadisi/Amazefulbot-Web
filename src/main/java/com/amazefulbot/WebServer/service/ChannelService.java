/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.validators.Prefix;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface ChannelService {
    Channel findByChannelId(int channelId);
    Channel findByLogin(String login);
    Channel updatePrefix(Channel channel, @Prefix char prefix);
    Channel setSilenced(Channel channel, boolean silenced);
    Channel updateChannel(Channel channel);
    Channel joinChannel(Channel channel);
    Channel partChannel(Channel channel);
}
