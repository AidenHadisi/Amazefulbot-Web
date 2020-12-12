package com.amazefulbot.WebServer.publicAPI.service;



import com.amazefulbot.WebServer.publicAPI.models.Commands;



public interface CommandsService {
    Commands[] getAllByChannelId(int channelId);
}
