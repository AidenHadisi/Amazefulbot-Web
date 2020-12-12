package com.amazefulbot.WebServer.publicAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@Document(collection = "commands")
public class Commands {
    @Id
    @JsonIgnore
    private String id;

    @NotEmpty
    @Field(name = "id")
    @JsonIgnore
    private int channelId;

    private String name;

    private boolean enabled;

    private int cooldown;

    private int user_cooldown;

    private String[] aliases;

    private int role;

    private int stream_status;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
