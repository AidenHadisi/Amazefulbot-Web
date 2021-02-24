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

}
