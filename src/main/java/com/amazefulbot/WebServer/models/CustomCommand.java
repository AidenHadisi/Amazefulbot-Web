/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("customcommands")
public class CustomCommand {
    @Id
    private String _id;
    private int id;
    private String name;
    private boolean custom = true;
    private boolean enabled = true;
    private int cooldown = 5000;
    private int user_cooldown = 15000;
    private List<String> aliases;
    private int role = 100;
    private int stream_status = 200;
    private String response;
    private boolean has_vars = false;
    private int count = 0;
    private Timers timers;


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
        private int min_count = 10;
        private int interval = 180000;
        private int stream_status = 200;

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
