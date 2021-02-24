/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;


import com.amazefulbot.WebServer.models.UserLevel;

public interface UserLevelService {
    UserLevel findOrCreateByChannelId(int channelId);
    UserLevel updateUserLevel(UserLevel userLevel);
}
