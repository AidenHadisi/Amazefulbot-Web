/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Alerts;
import com.amazefulbot.WebServer.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerts")
public class AlertsController {
    @Autowired
    private AlertsService alertsService;

    @GetMapping("/")
    public Alerts findById(@AuthenticatedUser UserPrincipal principal) {
        var channel = principal.getCurrent_channel();
        return alertsService.findOrCreateById(channel.getId());
    }
}
