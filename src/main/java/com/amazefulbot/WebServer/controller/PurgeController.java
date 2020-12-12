/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Purge;
import com.amazefulbot.WebServer.service.PurgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purge")
public class PurgeController {
    @Autowired
    private PurgeService purgeService;

    @GetMapping(value = "/")
    public Purge getConfig(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return purgeService.findOrCreateById(channel.getId());
    }
}
