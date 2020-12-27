/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.UserLevels;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document("userlevels")
public class UserLevel {
    @Id
    private String _id;

    @ChannelID
    private int id;

    @UserLevels
    private HashMap<String, Integer> users;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, Integer> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, Integer> users) {
        this.users = users;
    }
}
