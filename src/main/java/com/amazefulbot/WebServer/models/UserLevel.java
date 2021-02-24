/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.UserLevels;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.Set;

@Document("userlevels")
public class UserLevel {
    @Id
    private String id;


    @Field("id")
    @Indexed(unique = true)
    @ChannelID
    private int channelId;

    @UserLevels
    private HashMap<String, Integer> users = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public HashMap<String, Integer> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, Integer> users) {
        Set<String> keySet = users.keySet();
        for (String key : keySet) {
            String newKey = key.toLowerCase();
            this.users.put(newKey, users.get(key));
        }
    }
}
