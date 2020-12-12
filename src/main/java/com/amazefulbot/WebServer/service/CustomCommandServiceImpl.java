/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.CustomCommand;
import com.amazefulbot.WebServer.repository.CustomCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomCommandServiceImpl implements CustomCommandService {

    @Autowired
    private CustomCommandRepository customCommandRepository;


    @Override
    public CustomCommand[] findAllById(int id) {
        return customCommandRepository.findAllById(id);
    }
}
