/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.CommandAliases;
import com.amazefulbot.WebServer.validators.CommandRole;
import com.amazefulbot.WebServer.validators.StreamStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


@Document("customcommands")
@CompoundIndex(def = "{'id':1, 'name':1", unique = true)
public class CustomCommand {
    @Id
    private String id;

    @ChannelID
    @Field("id")
    private int channelId;

    @NotEmpty
    @Size(min = 1, max = 50, message = "Command name must be between 1 and 50 characters long")
    @Pattern(regexp = "^[^\\s]+$", message = "Command name cannot contain whitespaces")
    private String name;

    private boolean custom = true;
    private boolean enabled = true;

    @Min(value = 1000, message = "Cooldown cannot be less than 1.")
    @Max(value = 86400000, message = "Cooldown cannot be more than 86400")
    private int cooldown = 5000;
    @Min(value = 1000, message = "User cooldown cannot be less than 1.")
    @Max(value = 86400000, message = "User cooldown cannot be more than 86400")
    private int user_cooldown = 15000;


    @CommandAliases
    private List<String> aliases;

    @CommandRole
    private int role = 100;

    @StreamStatus
    private int stream_status = 200;


    @Size(min = 1, max = 2000, message = "Command response must be between 1 and 2000 characters long")
    private String response;
    private boolean has_vars = false;
    private int count = 0;

    @Valid
    private Timers timers;


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

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
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

    public int getStream_status() {
        return stream_status;
    }

    public void setStream_status(int stream_status) {
        this.stream_status = stream_status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isHas_vars() {
        return has_vars;
    }

    public void setHas_vars(boolean has_vars) {
        this.has_vars = has_vars;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timers getTimers() {
        return timers;
    }

    public void setTimers(Timers timers) {
        this.timers = timers;
    }

    private class Timers {
        private boolean enabled = false;
        @Min(value = 1, message = "Timer message count must be between 1 and 100")
        @Max(value = 100, message = "Timer message count must be between 1 and 100")
        private int min_count = 10;

        @Min(value = 60000, message = "Timer interval must be between 1 and 1440 minutes")
        @Max(value = 86400000, message = "Timer interval must be between 1 and 1440 minutes")
        private int interval = 180000;

        @StreamStatus
        private int stream_status = 200;

        public Timers() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getMin_count() {
            return min_count;
        }

        public void setMin_count(int min_count) {
            this.min_count = min_count;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }
    }
}
