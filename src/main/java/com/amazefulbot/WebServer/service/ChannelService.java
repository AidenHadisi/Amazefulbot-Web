/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.validators.Prefix;


public interface ChannelService {
    Channel findByChannelId(int channelId);
    Channel findByLogin(String login);
    Channel updatePrefix(Channel channel, @Prefix String prefix);
    Channel setSilenced(Channel channel, boolean silenced);

}
