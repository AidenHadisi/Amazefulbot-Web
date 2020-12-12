/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.service;

import com.amazefulbot.WebServer.models.Filters;
import com.amazefulbot.WebServer.repository.FiltersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiltersServiceImpl implements FiltersService {
    @Autowired
    private FiltersRepository filtersRepository;
    @Override
    public Filters findOrCreateById(int id) {
        var filtersOptional = filtersRepository.findForChannelById(id);
        Filters filters;
        if(filtersOptional.isPresent()) {
            filters = filtersOptional.get();
        }
        else {
            filters = new Filters();
            filters.setId(id);
            filtersRepository.save(filters);
        }
        return filters;
    }
}
