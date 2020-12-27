/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.converter.UserReferenceConverter;
import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.Prefix;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document(collection = "channels")
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Channel implements Serializable {

    @Id
    private String objId;

    @Indexed(unique = true)
    @Positive
    @ChannelID
    private int id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String display_name;

    private String type;


    private String broadcaster_type;

    private String profile_image_url;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;

    private String access_token;
    private String refresh_token;
    private boolean join = true;
    private boolean silenced = false;

    @Prefix
    private char prefix;

    private boolean suspended = false;

    @Field("editors")
    private String editorList[];

    @Transient
    @JsonSerialize
    private List<User> editors;

    private int shard = 2;

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBroadcaster_type() {
        return broadcaster_type;
    }

    public void setBroadcaster_type(String broadcaster_type) {
        this.broadcaster_type = broadcaster_type;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }

    public char getPrefix() {
        return prefix;
    }

    public void setPrefix(char prefix) {
        this.prefix = prefix;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public String[] getEditorList() {
        return editorList;
    }

    public void setEditorList(String[] editorList) {
        this.editorList = editorList;
    }


    public List<User> getEditors() {
        return editors;
    }

    public void setEditors(List<User> editors) {
        this.editors = editors;
    }

    public int getShard() {
        return shard;
    }

    public void setShard(int shard) {
        this.shard = shard;
    }

    public void populateUsers() {
        if(editorList != null && editorList.length > 0) {
            for (var user : this.editorList) {
                this.editors.add(new UserReferenceConverter().convert(user).get());
            }
        }
        else {
            editors = new ArrayList<>();
        }
    }
}
