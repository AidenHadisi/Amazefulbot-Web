/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Purge;
import com.amazefulbot.WebServer.repository.PurgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurgeServiceImpl implements PurgeService {
    @Autowired
    private PurgeRepository purgeRepository;


    @Override
    public Purge findOrCreateById(int id) {
//            var purgeOptional = purgeRepository.findById(id);
//            Purge purge;
//            if(purgeOptional.isPresent()) {
//                purge = purgeOptional.get();
//            }
//            else {
//                purge = new Purge();
//                purge.(id);
//                purgeRepository.save(purge);
//            }
//            return purge;
        return new Purge();
    }
}
