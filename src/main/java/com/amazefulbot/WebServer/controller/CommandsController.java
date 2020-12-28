/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.exceptions.CustomException;
import com.amazefulbot.WebServer.models.Command;
import com.amazefulbot.WebServer.service.CommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/commands")
public class CommandsController {
    @Autowired
    private CommandsService commandsService;

    @GetMapping(value = "")
    public Command[] getCommands(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return commandsService.findAllByChannelId(channel.getId());
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Command setCommand(@Valid @RequestBody Command command) {
        Optional<Command> commandOptional = commandsService.findCommandById(command.getId());
        if(!commandOptional.isPresent()) {
            throw new CustomException("That command no longer exists");
        }
        var commandFromDB = commandOptional.get();
        commandFromDB.setStream_status(command.getStream_status());
        commandFromDB.setEnabled(command.isEnabled());
        commandFromDB.setRole(command.getRole());
        commandFromDB.setUser_cooldown(command.getUser_cooldown());
        commandFromDB.setCooldown(command.getCooldown());
        return commandsService.updateCommand(commandFromDB);

    }

    @PostMapping(value = "/enable", consumes = "application/json", produces = "application/json")
    public Command enableCommand(@RequestBody Map<String, Object> body) {
        Optional<Command> commandOptional = commandsService.findCommandById(body.get("id").toString());
        if(!commandOptional.isPresent()) {
            throw new CustomException("That command no longer exists");
        }
        Command command = commandOptional.get();
        return commandsService.enableCommand(command,(boolean) body.get("enabled"));
    }

}
