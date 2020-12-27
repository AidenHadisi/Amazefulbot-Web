/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.models.Filters;
import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.response.APISuccessResponse;
import com.amazefulbot.WebServer.service.ChannelService;
import com.amazefulbot.WebServer.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @Autowired
    private FiltersService filtersService;

    @GetMapping(value = "/id/{channelId}")
    public Channel findById(@PathVariable ("channelId") int channelId) {
        return channelService.findByChannelId(channelId);
    }

    @GetMapping(value = "")
    public Channel getConfig(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        channel.populateUsers();
        return channel;
    }


    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Channel setChannel(@Valid @RequestBody Channel channel) {

        return channelService.updateChannel(channel);
    }


    @PostMapping(value = "/prefix", consumes = "application/json", produces = "application/json")
    public Channel setPrefix(@AuthenticatedUser UserPrincipal principal, @RequestBody Map<String, Object> body) {
            var channel = principal.getCurrent_channel();
            var prefix =  body.get("prefix").toString();

            return channelService.updatePrefix(channel, prefix);
    }


    @PostMapping(value = "/silence", consumes = "application/json", produces = "application/json")
    public String setSilenced(@AuthenticatedUser UserPrincipal principal, @RequestBody Map<String, Object> body) {
            var channel = principal.getCurrent_channel();
            var sielnced = (boolean) body.get("silenced");
            channelService.setSilenced(channel, sielnced);
            if(sielnced) {
                return "Bot was successfully silenced";
            }
            else {
                return "Bot was successfully unsilenced";
            }
    }



}
