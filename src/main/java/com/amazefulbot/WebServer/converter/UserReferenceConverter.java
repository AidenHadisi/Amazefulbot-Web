/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.converter;

import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserReferenceConverter implements Converter<String, Optional<User>> {
    private static UserRepository userRepository;

    public UserReferenceConverter() {
        super();
    }
    @Autowired
    public UserReferenceConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> convert(String objectId) {
        return this.userRepository.findById(objectId);
    }
}