package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.Channel;
import com.amazefulbot.WebServer.publicAPI.repository.PublicChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PublicChannelServiceImpl implements PublicChannelService {
    @Autowired
    private PublicChannelRepository publicChannelRepository;

    @Override
    public Channel getById(int channelId) {

        Optional<Channel> channel = publicChannelRepository.getByChannelId(channelId);

        if(!channel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No channel found");
        }
        return channel.get();
    }

    @Override
    public Channel getByLogin(String login) {
        Optional<Channel> channel = publicChannelRepository.getByLogin(login);

        if(!channel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No channel found");
        }
        return channel.get();
    }
}
