package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.CustomCommand;

public interface PublicCustomCommandService {
    CustomCommand[] getByChannelId(int channelId);
}
