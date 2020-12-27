/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Command;
import com.amazefulbot.WebServer.service.CommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/commands")
public class CommandsController {
    @Autowired
    private CommandsService commandsService;

    @GetMapping(value = "/")
    public Command[] getCommands(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return commandsService.findAllByChannelId(channel.getId());
    }

    @PostMapping(value = "/command", consumes = "application/json", produces = "application/json")
    public Command setCommand(@Valid @RequestBody Command command) {
        return commandsService.updateCommand(command);
    }

}
