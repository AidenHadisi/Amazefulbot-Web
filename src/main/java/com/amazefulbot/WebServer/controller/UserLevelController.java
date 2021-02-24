/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;

import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.UserLevel;
import com.amazefulbot.WebServer.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/userlevel")
public class UserLevelController {
    @Autowired
    private UserLevelService userLevelService;

    @GetMapping("")
    public UserLevel getUserLevels(@AuthenticatedUser UserPrincipal userPrincipal) {
        return userLevelService.findOrCreateByChannelId(userPrincipal.getCurrent_channel().getId());
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public UserLevel setUserLevels(@Valid @RequestBody UserLevel userLevel) {
        return userLevelService.updateUserLevel(userLevel);
    }



}
