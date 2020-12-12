/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import org.bson.BsonRegularExpression;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;


@Document("blacklists")
public class Blacklist {
    @Id
    private String _id;
    private int id;
    private boolean enabled = true;
    @CreatedDate
    private Date created_at;
    private int creator_id;
    private String creator_login;
    @Field("public")
    private boolean pub = false;
    private String name;
    private String description;
    private BsonRegularExpression allPhrases;
    private String last_updated_by;
    private int stream_status = 200;
    private int scan = 0;
    private boolean ban = false;
    private int timeout_duration = 30;
    private boolean exponential = true;
    private int base = 3;
    private int reset_strike = 180000;
    private List<Phrases> phrases;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String getCreator_login() {
        return creator_login;
    }

    public void setCreator_login(String creator_login) {
        this.creator_login = creator_login;
    }

    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BsonRegularExpression getAllPhrases() {
        return allPhrases;
    }

    public void setAllPhrases(BsonRegularExpression allPhrases) {
        this.allPhrases = allPhrases;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public int getStream_status() {
        return stream_status;
    }

    public void setStream_status(int stream_status) {
        this.stream_status = stream_status;
    }

    public int getScan() {
        return scan;
    }

    public void setScan(int scan) {
        this.scan = scan;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public int getTimeout_duration() {
        return timeout_duration;
    }

    public void setTimeout_duration(int timeout_duration) {
        this.timeout_duration = timeout_duration;
    }

    public boolean isExponential() {
        return exponential;
    }

    public void setExponential(boolean exponential) {
        this.exponential = exponential;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getReset_strike() {
        return reset_strike;
    }

    public void setReset_strike(int reset_strike) {
        this.reset_strike = reset_strike;
    }

    public List<Phrases> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrases> phrases) {
        this.phrases = phrases;
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

    private class Phrases {
        private String phrase;
        private boolean regex;

        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        public boolean isRegex() {
            return regex;
        }

        public void setRegex(boolean regex) {
            this.regex = regex;
        }
    }



}
