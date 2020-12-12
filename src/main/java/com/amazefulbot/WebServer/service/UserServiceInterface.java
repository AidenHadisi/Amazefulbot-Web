/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.User;


public interface UserServiceInterface {
    User findByLogin(String login);
}
