/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.UserLevel;
import com.amazefulbot.WebServer.repository.UserLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLevelServiceImpl implements UserLevelService {

    @Autowired
    private UserLevelRepository userLevelRepository;
    @Override
    public UserLevel findOrCreateByChannelId(int channelId) {
        var userLevelOptional = userLevelRepository.findByChannelId(channelId);
        UserLevel userLevel;
        if(userLevelOptional.isPresent()) {
            userLevel = userLevelOptional.get();
        }
        else  {
            userLevel = new UserLevel();
            userLevel.setChannelId(channelId);
        }
        return userLevelRepository.save(userLevel);
    }

    @Override
    public UserLevel updateUserLevel(UserLevel userLevel) {
        return userLevelRepository.save(userLevel);
    }
}
