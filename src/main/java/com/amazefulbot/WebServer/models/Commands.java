/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document("commands")
public class Commands {
    @Id
    private String id;
    @Field(name = "id")
    @JsonIgnore
    private int channelId;
    private String name;
    private String usage;
    private String description;
    private boolean enabled;
    private int cooldown;
    private int user_cooldown;
    private List<String> aliases;
    private int role;
    private int minimum_role;
    private int stream_status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getUser_cooldown() {
        return user_cooldown;
    }

    public void setUser_cooldown(int user_cooldown) {
        this.user_cooldown = user_cooldown;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getMinimum_role() {
        return minimum_role;
    }

    public void setMinimum_role(int minimum_role) {
        this.minimum_role = minimum_role;
    }

    public int getStream_status() {
        return stream_status;
    }

    public void setStream_status(int stream_status) {
        this.stream_status = stream_status;
    }
}
