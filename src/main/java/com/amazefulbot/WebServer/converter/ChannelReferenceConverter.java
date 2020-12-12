/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.converter;

import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.repository.ChannelRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ChannelReferenceConverter implements Converter<ObjectId, Optional<Channel>> {
    private static ChannelRepository channelRepository;

    public ChannelReferenceConverter() {
        super();
    }
    @Autowired
    public ChannelReferenceConverter(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Optional<Channel> convert(ObjectId objectId) {
        return this.channelRepository.getByObjId(objectId.toString());
    }
}