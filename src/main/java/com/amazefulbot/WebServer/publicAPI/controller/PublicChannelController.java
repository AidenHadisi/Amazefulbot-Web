package com.amazefulbot.WebServer.publicAPI.controller;


import com.amazefulbot.WebServer.config.PublicAPI;
import com.amazefulbot.WebServer.publicAPI.models.Channel;
import com.amazefulbot.WebServer.publicAPI.service.PublicChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@PublicAPI
@RequestMapping("/channel")
public class PublicChannelController {

    @Autowired
    private PublicChannelService channelService;

    @GetMapping(params = {"id"})
    public Channel getById(@RequestParam("id") int channelId) {
        return channelService.getById(channelId);
    }

    @GetMapping(params = "login")
    public Channel getByLogin(@RequestParam String login) {
        return channelService.getByLogin(login);
    }
}
