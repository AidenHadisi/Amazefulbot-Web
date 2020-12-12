/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Blacklist;
import com.amazefulbot.WebServer.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blacklist")
public class BlackListController {

    @Autowired
    private BlacklistService blacklistService;

    @GetMapping(value = "/")
    public Blacklist[] getAllById(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return blacklistService.findAllById(channel.getId());
    }
}
