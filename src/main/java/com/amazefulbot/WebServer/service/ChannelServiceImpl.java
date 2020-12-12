/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;


import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository channelRepository;


    @Override
    public Channel findByChannelId(int channelId) {
        return channelRepository.findById(channelId);
    }

    @Override
    public Channel findByLogin(String login) {
        return channelRepository.findByLogin(login);
    }

    @Override
    public Channel updatePrefix(Channel channel, char prefix) {
        if(prefix == '!' || prefix == '$' || prefix == '#' || prefix == '%' || prefix == '^' || prefix == '&' || prefix == '*' || prefix == '?') {
            channel.setPrefix(prefix);
            return channelRepository.save(channel);
        }
        throw new RuntimeException("Failed to set prefix");
    }

    @Override
    public Channel setSilenced(Channel channel, boolean silenced) {
        if(silenced == true) {
            channel.setSilenced(true);
        }
        else {
            channel.setSilenced(false);
        }
        return channelRepository.save(channel);
    }

}
