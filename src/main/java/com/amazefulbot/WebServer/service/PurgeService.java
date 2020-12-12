/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Purge;

public interface PurgeService {

    Purge findOrCreateById(int id);
}
