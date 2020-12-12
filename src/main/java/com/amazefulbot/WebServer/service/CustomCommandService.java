/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.CustomCommand;

public interface CustomCommandService {
    CustomCommand[] findAllById(int id);
}
