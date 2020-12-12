/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;


import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.repository.ChannelRepository;
import com.amazefulbot.WebServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;



    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
