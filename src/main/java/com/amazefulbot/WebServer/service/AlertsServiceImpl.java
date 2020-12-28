/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Alerts;
import com.amazefulbot.WebServer.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertsServiceImpl implements AlertsService {
    @Autowired
    private AlertsRepository alertsRepository;

    @Override
    public Alerts findOrCreateByChannel(int channelId) {
        var alertsOptional = alertsRepository.findByChannelId(channelId);
        Alerts alerts;
        if(alertsOptional.isPresent()) {
            alerts = alertsOptional.get();

        }
        else {
            alerts = new Alerts();
            alerts.setChannelId(channelId);
            alertsRepository.save(alerts);
        }
        return alerts;
    }

    @Override
    public Alerts updateAlerts(Alerts alerts) {
        return alertsRepository.save(alerts);
    }
}
