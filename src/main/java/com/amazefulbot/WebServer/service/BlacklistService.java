/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Blacklist;

public interface BlacklistService {
    Blacklist[] findAllById(int id);
}
