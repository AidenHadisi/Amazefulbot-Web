/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("purges")
public class Purge {
    @Id
    private String _id;

    private int id;
    private boolean enabled = false;
    private int max_lookback_time = 180000;
    private boolean continuous_timeout = true;
    private int continuous_time = 60000;
    private Exempt exempt;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getMax_lookback_time() {
        return max_lookback_time;
    }

    public void setMax_lookback_time(int max_lookback_time) {
        this.max_lookback_time = max_lookback_time;
    }

    public boolean isContinuous_timeout() {
        return continuous_timeout;
    }

    public void setContinuous_timeout(boolean continuous_timeout) {
        this.continuous_timeout = continuous_timeout;
    }

    public int getContinuous_time() {
        return continuous_time;
    }

    public void setContinuous_time(int continuous_time) {
        this.continuous_time = continuous_time;
    }

    public Exempt getExempt() {
        return exempt;
    }

    public void setExempt(Exempt exempt) {
        this.exempt = exempt;
    }

    private class Exempt {
        private boolean subscriber = false;
        private boolean vip = false;
        private boolean regular = false;

        public boolean isSubscriber() {
            return subscriber;
        }

        public void setSubscriber(boolean subscriber) {
            this.subscriber = subscriber;
        }

        public boolean isVip() {
            return vip;
        }

        public void setVip(boolean vip) {
            this.vip = vip;
        }

        public boolean isRegular() {
            return regular;
        }

        public void setRegular(boolean regular) {
            this.regular = regular;
        }
    }
}
