/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Channel;


public interface ChannelService {
    Channel findByChannelId(int channelId);
    Channel findByLogin(String login);
    Channel updatePrefix(Channel channel, char prefix);
    Channel setSilenced(Channel channel, boolean silenced);

}
