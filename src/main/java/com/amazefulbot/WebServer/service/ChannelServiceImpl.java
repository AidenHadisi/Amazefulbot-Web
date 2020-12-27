/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;


import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.repository.ChannelRepository;
import com.amazefulbot.WebServer.validators.Prefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
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
    public Channel updatePrefix(Channel channel, @Prefix String prefix) {
            channel.setPrefix(prefix.charAt(0));

            return channelRepository.save(channel);
    }

    @Override
    public Channel setSilenced(Channel channel, boolean silenced) {
        if(silenced) {
            channel.setSilenced(true);
        }
        else {
            channel.setSilenced(false);
        }
        return channelRepository.save(channel);
    }

    @Override
    public Channel updateChannel(Channel channel) {
        return channelRepository.save(channel);
    }

}
