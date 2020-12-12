package com.amazefulbot.WebServer.publicAPI.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("customcommands")
public class CustomCommand {

    @Id
    @JsonIgnore
    private String id;
    @Field("id")
    @JsonIgnore
    private int channelId;
    private String name;
    private boolean custom;
    private boolean enabled;
    private int cooldown;
    private int user_cooldown;
    private String[] aliases;
    private int role;
    private int stream_status;
    private String response;
    @JsonIgnore
    private boolean has_vars;

    @PersistenceConstructor
    public CustomCommand(String id, int channelId, String name, boolean custom, boolean enabled, int cooldown, int user_cooldown, String[] aliases, int role, int stream_status, String response, boolean has_vars) {
        this.id = id;
        this.channelId = channelId;
        this.name = name;
        this.custom = custom;
        this.enabled = enabled;
        this.cooldown = cooldown / 1000;
        this.user_cooldown = user_cooldown / 1000;
        this.aliases = aliases;
        this.role = role;
        this.stream_status = stream_status;
        this.response = has_vars ?  "$(evaluate)" : response;
        this.has_vars = has_vars;
    }

    public String getId() {
        return id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void setId(String id) {
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

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
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
}
