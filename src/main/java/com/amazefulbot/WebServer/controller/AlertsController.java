/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Alerts;
import com.amazefulbot.WebServer.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alerts")
public class AlertsController {
    @Autowired
    private AlertsService alertsService;

    @GetMapping("")
    public Alerts findById(@AuthenticatedUser UserPrincipal principal) {
        return alertsService.findOrCreateByChannel(principal.getCurrent_channel().getId());
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Alerts setAlert(@Valid @RequestBody Alerts alerts) {
        return alertsService.updateAlerts(alerts);
    }
}
