/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.CustomCommand;
import com.amazefulbot.WebServer.service.CustomCommandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("custom")
public class CustomCommandController {
    @Autowired
    private CustomCommandServiceImpl customCommandService;

    @GetMapping(value = "/")
    public CustomCommand[] getCommands(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return customCommandService.findAllById(channel.getId());
    }
}
