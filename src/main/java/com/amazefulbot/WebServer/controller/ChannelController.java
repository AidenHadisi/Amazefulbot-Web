/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.models.Filters;
import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.response.ErrorSuccessResponse;
import com.amazefulbot.WebServer.service.ChannelService;
import com.amazefulbot.WebServer.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping(value = "/config")
    public ConfigData getConfig(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        if(channel == null)  throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Channel does not exist");
        var filters = filtersService.findOrCreateById(channel.getId());
        channel.populateUsers();
        var editors = channel.getEditors();
        return new ConfigData(channel, editors, filters);
    }


    @PostMapping(value = "/prefix", consumes = "application/json", produces = "application/json")
    public ErrorSuccessResponse setPrefix(@AuthenticatedUser UserPrincipal principal, @RequestBody Map<String, Object> body) {
        try {
            var channel = principal.getCurrent_channel();

            var prefix =  body.get("prefix").toString().charAt(0);

            channelService.updatePrefix(channel, prefix);
            return new ErrorSuccessResponse("Successfully set prefix to " + prefix, "");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ErrorSuccessResponse("", "Failed to update prefix.");
        }
    }


    @PostMapping(value = "/silence", consumes = "application/json", produces = "application/json")
    public ErrorSuccessResponse setSilenced(@AuthenticatedUser UserPrincipal principal, @RequestBody Map<String, Object> body) {
        try {
            var channel = principal.getCurrent_channel();

            var sielnced = (boolean) body.get("silenced");

            channelService.setSilenced(channel, sielnced);
            if(sielnced == true) {
                return new ErrorSuccessResponse("Bot was successfully silenced", "");
            }
            else {
                return new ErrorSuccessResponse("Bot was successfully unsilenced", "");

            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ErrorSuccessResponse("", "Failed to update prefix.");
        }
    }

    private class ConfigData {
        private Channel channel;
        private List<User> editors;
        private Filters filters;

        public ConfigData(Channel channel, List<User> editors, Filters filters) {
            this.channel = channel;
            this.editors = editors;
            this.filters = filters;
        }

        public Channel getChannel() {
            return channel;
        }

        public void setChannel(Channel channel) {
            this.channel = channel;
        }

        public List<User> getEditors() {
            return editors;
        }

        public void setEditors(List<User> editors) {
            this.editors = editors;
        }

        public Filters getFilters() {
            return filters;
        }

        public void setFilters(Filters filters) {
            this.filters = filters;
        }
    }



}
