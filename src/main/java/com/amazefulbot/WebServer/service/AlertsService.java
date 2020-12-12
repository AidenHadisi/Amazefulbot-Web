/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Alerts;

public interface AlertsService {
    Alerts findOrCreateById(int id);
}
