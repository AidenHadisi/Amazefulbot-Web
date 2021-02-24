/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.StreamStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.HashMap;

@Document("notifies")
public class Notify {
    @Id
    private String id;

    @Field("id")
    @ChannelID
    private int channelId;

    @StreamStatus
    private int stream_status = 200;

    private HashMap<String, Boolean> exempt;
    private Filters filters;

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

    public int getStream_status() {
        return stream_status;
    }

    public void setStream_status(int stream_status) {
        this.stream_status = stream_status;
    }

    public HashMap<String, Boolean> getExempt() {
        return exempt;
    }

    public void setExempt(HashMap<String, Boolean> exempt) {
        this.exempt = exempt;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    private class Filters {
        private boolean link = false;
        private boolean zalgo = false;
        private boolean emoji = false;
        private boolean foreign = false;
        private boolean symbols = false;

        public boolean isLink() {
            return link;
        }

        public void setLink(boolean link) {
            this.link = link;
        }

        public boolean isZalgo() {
            return zalgo;
        }

        public void setZalgo(boolean zalgo) {
            this.zalgo = zalgo;
        }

        public boolean isEmoji() {
            return emoji;
        }

        public void setEmoji(boolean emoji) {
            this.emoji = emoji;
        }

        public boolean isForeign() {
            return foreign;
        }

        public void setForeign(boolean foreign) {
            this.foreign = foreign;
        }

        public boolean isSymbols() {
            return symbols;
        }

        public void setSymbols(boolean symbols) {
            this.symbols = symbols;
        }
    }


}
