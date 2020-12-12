package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.CustomCommand;
import com.amazefulbot.WebServer.publicAPI.repository.PublicCustomCommandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicCustomCommandServiceImpl implements PublicCustomCommandService {
    @Autowired
    private PublicCustomCommandsRepository publicCustomCommandsRepository;
    @Override
    public CustomCommand[] getByChannelId(int channelId) {
        var commands = publicCustomCommandsRepository.getByChannelId(channelId);
        return commands;
    }
}
