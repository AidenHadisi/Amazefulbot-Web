/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.converter.ChannelReferenceConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    @Id
    private String objId;

    @Indexed(unique = true)
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



//    private String channel;
//    @Field(name = "primary_channel")
//    @JsonIgnore
//    @Transient
//    @JsonSerialize

    private ObjectId primary_channel;

    @Field("channels")
    private ObjectId[] channelList;

    @Transient
    @JsonSerialize
    private List<Channel> channels;
    private boolean suspended = false;
    private boolean admin = false;


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

    public ObjectId getPrimary_channel() {
        return primary_channel;
    }

    public void setPrimary_channel(ObjectId primary_channel) {
        this.primary_channel = primary_channel;
    }

    public ObjectId[] getChannelList() {
        return channelList;
    }

    public void setChannelList(ObjectId[] channelList) {
        this.channelList = channelList;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void populateChannels() {
        if(channelList != null && channelList.length > 0) {
            for (var channel : this.channelList) {
                this.channels.add(new ChannelReferenceConverter().convert(channel).get());
            }
        }
        else {
            channels = new ArrayList<>();
        }
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
