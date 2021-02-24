/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Document("purges")
public class Purge {
    @Id
    private String id;

    @ChannelID
    @Field("id")
    private int channelId;


    private boolean enabled = false;

    @Min(value = 30000, message = "Lookback time cannot be less than 30 seconds")
    @Max(value = 300000, message = "Loockback time cannot be over 300 seconds")
    private int max_lookback_time = 180000;

    private boolean continuous_timeout = true;

    @Min(value = 10000, message = "Retention time cannot be less than 10 seconds")
    @Max(value = 600000, message = "Retention time cannot be over 600 seconds")
    private int continuous_time = 60000;
    private Exempt exempt;



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
