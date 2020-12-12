package com.amazefulbot.WebServer.publicAPI.service;


import com.amazefulbot.WebServer.publicAPI.models.Channel;

public interface PublicChannelService {
    Channel getById(int channelId);
    Channel getByLogin(String login);
}
