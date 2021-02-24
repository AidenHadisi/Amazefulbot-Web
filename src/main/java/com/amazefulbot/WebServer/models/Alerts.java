/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Document("alerts")
public class Alerts {
    @Id
    private String id;

    @Field("id")
    @ChannelID
    @Indexed(unique = true)
    private int channelId;
    @Valid
    private Sub sub;
    @Valid
    private Resub resub;
    @Valid
    private SubGift subGift;
    @Valid
    private CommunityGift communityGift;

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

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }

    public Resub getResub() {
        return resub;
    }

    public void setResub(Resub resub) {
        this.resub = resub;
    }

    public SubGift getSubGift() {
        return subGift;
    }

    public void setSubGift(SubGift subGift) {
        this.subGift = subGift;
    }

    public CommunityGift getCommunityGift() {
        return communityGift;
    }

    public void setCommunityGift(CommunityGift communityGift) {
        this.communityGift = communityGift;
    }

    private class Sub {

        private boolean enabled =false;
        @NotEmpty
        @Size(min = 1, max = 400, message = "Alert message must be between 1 and 400 characters long")
        private String message = "@$(user), Thank you for $(tier) subscription.";

        public Sub() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private class Resub {
        private boolean enabled =false;

        @NotEmpty
        @Size(min = 1, max = 400, message = "Alert message must be between 1 and 400 characters long")
        private String message = "@$(user), Thank you for subscribing for $(months) months in a row.";

        public Resub() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private class SubGift {
        private boolean enabled =false;

        public SubGift() {
        }

        @NotEmpty
        @Size(min = 1, max = 400, message = "Alert message must be between 1 and 400 characters long")
        private String message = "@$(gifter), Thank you for gifting a $(tier) subscription to $(user).";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    private class CommunityGift {
        private boolean enabled =false;
        @NotEmpty
        @Size(min = 1, max = 400, message = "Alert message must be between 1 and 400 characters long")
        private String message = "@$(gifter), Thank you for gifting $(count) tier $(tier) subs to $(channel)'s community.";

        public CommunityGift() {
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
