/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.exceptions.EmptyOptionalException;
import com.amazefulbot.WebServer.models.Command;
import com.amazefulbot.WebServer.models.CustomCommand;
import com.amazefulbot.WebServer.service.CustomCommandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("custom")
public class CustomCommandController {
    @Autowired
    private CustomCommandServiceImpl customCommandService;

    @GetMapping(value = "")
    public CustomCommand[] getCommands(@AuthenticatedUser UserPrincipal principal) {
        return customCommandService.findAllByChannelId(principal.getCurrent_channel().getId());
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public CustomCommand setCommand(@Valid @RequestBody CustomCommand command) {
        Optional<CustomCommand> commandOptional = customCommandService.findCommandById(command.getId());
        if(!commandOptional.isPresent()) {
            throw new EmptyOptionalException("That command no longer exists");
        }
        var commandFromDB = commandOptional.get();
        commandFromDB.setName(command.getName());
        commandFromDB.setAliases(command.getAliases());
        commandFromDB.setStream_status(command.getStream_status());
        commandFromDB.setEnabled(command.isEnabled());
        commandFromDB.setRole(command.getRole());
        commandFromDB.setResponse(command.getResponse());
        commandFromDB.setHas_vars(command.getResponse().matches("\\$\\(.+?\\)"));
        commandFromDB.setUser_cooldown(command.getUser_cooldown());
        commandFromDB.setCooldown(command.getCooldown());
        commandFromDB.setTimers(command.getTimers());
        return customCommandService.updateCommand(commandFromDB);

    }

    @PostMapping(value = "/enable", consumes = "application/json", produces = "application/json")
    public CustomCommand enableCommand(@RequestBody Map<String, Object> body) {
        Optional<CustomCommand> commandOptional = customCommandService.findCommandById(body.get("id").toString());
        if(!commandOptional.isPresent()) {
            throw new EmptyOptionalException("That command no longer exists");
        }
        CustomCommand command = commandOptional.get();
        return customCommandService.enableCommand(command,(boolean) body.get("enabled"));
    }
}
