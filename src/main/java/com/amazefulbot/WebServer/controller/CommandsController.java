/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Commands;
import com.amazefulbot.WebServer.service.CommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
public class CommandsController {
    @Autowired
    private CommandsService commandsService;

    @GetMapping(value = "/")
    public Commands[] getCommands(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return commandsService.findAllByChannelId(channel.getId());
    }

}
