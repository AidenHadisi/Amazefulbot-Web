/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("alerts")
public class Alerts {
    @Id
    private String _id;
    private int id;

    private Sub sub;
    private Resub resub;
    private SubGift subGift;
    private CommunityGift communityGift;

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
        private String message = "@$(user), Thank you for $(tier) subscription.";

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
        private String message = "@$(user), Thank you for subscribing for $(months) months in a row.";

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
        private String message = "@$(gifter), Thank you for gifting $(count) tier $(tier) subs to $(channel)'s community.";

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
