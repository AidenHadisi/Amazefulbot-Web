/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.models;

import com.amazefulbot.WebServer.validators.ChannelID;
import com.amazefulbot.WebServer.validators.StreamStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document("filters")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filters {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field("id")
    @ChannelID
    private int channelId;


    @Min(value = 5, message = "Raid viewer count must be between 1 and 100000")
    @Max(value = 100000, message = "Raid viewer count must be between 1 and 100000")
    private int raid_count = 30;


    @Min(value = 30, message = "Raid timeout must be between 30 and 1800 seconds")
    @Max(value = 1800000, message = "Raid timeout must be between 30 and 1800 seconds")
    private int raid_timeout = 60000;

    @Valid
    private Caps caps;

    @Valid
    private Symbols symbols;

    @Valid
    private Length length;

    @Valid
    private Zalgo zalgo;

    @Valid
    private Emotes emotes;

    @Valid
    private Emojis emojis;

    @Valid
    private Repetition repetition;

    @Valid
    private SoloSpam solo_spam;

    @Valid
    private Link link;

    @Valid
    private English english;



    private class Caps {
        private boolean enabled = false;
        private String description = "Timeout users for using excessive CAPS.";

        @Min(value = 1, message = "Minimum characters must be between 1 and 500")
        @Max(value = 500, message = "Minimum characters must be between 1 and 500")
        private int min_chars = 50;

        @Min(value = 0)
        @Max(value = 500)
        private int max_caps = 100;

        @Min(value = 0)
        @Max(value = 1)
        private double max_percentage = 0.9;

        @StreamStatus
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;


        private int announce_cooldown = 60000;

        @NotEmpty(message = "Announcement message cannot be empty")
        private String message = "Please stop spamming caps.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Caps(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public int getMax_caps() {
            return max_caps;
        }

        public void setMax_caps(int max_caps) {
            this.max_caps = max_caps;
        }

        public double getMax_percentage() {
            return max_percentage;
        }

        public void setMax_percentage(double max_percentage) {
            this.max_percentage = max_percentage;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Symbols {
        private boolean enabled = false;
        private String description = "Timeout users for using excessive symbols.";
        private int min_chars = 50;
        private int max_symbols = 100;
        private double max_percentage = 0.9;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop spamming symbols.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Symbols(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public int getMax_symbols() {
            return max_symbols;
        }

        public void setMax_symbols(int max_symbols) {
            this.max_symbols = max_symbols;
        }

        public double getMax_percentage() {
            return max_percentage;
        }

        public void setMax_percentage(double max_percentage) {
            this.max_percentage = max_percentage;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Length {
        private boolean enabled = false;
        private String description = "Timeout users for posting lengthy messages in chat.";
        private int max_length = 350;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop posting lengthy messages.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Length(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMax_length() {
            return max_length;
        }

        public void setMax_length(int max_length) {
            this.max_length = max_length;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Zalgo {
        private boolean enabled = false;
        private String description = "Timeout users for posting zalgo characters in chat.";
        private int min_chars = 1;
        private int max_zalgo = 1;
        private double max_percentage = 0;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop using zalgo characters.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Zalgo(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public int getMax_zalgo() {
            return max_zalgo;
        }

        public void setMax_zalgo(int max_zalgo) {
            this.max_zalgo = max_zalgo;
        }

        public double getMax_percentage() {
            return max_percentage;
        }

        public void setMax_percentage(double max_percentage) {
            this.max_percentage = max_percentage;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Emotes {
        private boolean enabled = false;
        private String description = "Timeout users for using excessive Twitch emotes.";
        private int max_emotes = 20;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop spamming emotes.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Emotes(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMax_emotes() {
            return max_emotes;
        }

        public void setMax_emotes(int max_emotes) {
            this.max_emotes = max_emotes;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Emojis {
        private boolean enabled = false;
        private String description = "Timeout users for using excessive emojis.";
        private int max_emojis = 20;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop spamming emojis.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Emojis(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMax_emojis() {
            return max_emojis;
        }

        public void setMax_emojis(int max_emojis) {
            this.max_emojis = max_emojis;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Repetition {
        private boolean enabled = false;
        private String description = "Timeout users for repetitive words in their messages.";
        private int min_chars = 50;
        private int max_repetitions = 7;
        private int min_unique = 15;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop repeating yourself.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Repetition(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public int getMax_repetitions() {
            return max_repetitions;
        }

        public void setMax_repetitions(int max_repetitions) {
            this.max_repetitions = max_repetitions;
        }

        public int getMin_unique() {
            return min_unique;
        }

        public void setMin_unique(int min_unique) {
            this.min_unique = min_unique;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class SoloSpam {
        private boolean enabled = false;
        private String description = "Timeout users for solo spamming in chat.";
        private int min_chars = 50;
        private double similarity = 0.9;
        private int max_messages = 3;
        private int reset_message = 180000;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please refrain from solo spamming in chat.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public SoloSpam(Exempt exempt) {
            this.exempt = exempt;
        }
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public double getSimilarity() {
            return similarity;
        }

        public void setSimilarity(double similarity) {
            this.similarity = similarity;
        }

        public int getMax_messages() {
            return max_messages;
        }

        public void setMax_messages(int max_messages) {
            this.max_messages = max_messages;
        }

        public int getReset_message() {
            return reset_message;
        }

        public void setReset_message(int reset_message) {
            this.reset_message = reset_message;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class Link {
        private boolean enabled = false;
        private String description = "Timeout users for posting links in chat.";
        private List<String> whitelist;
        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Please stop posting links.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public Link(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;

        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getWhitelist() {
            return whitelist;
        }

        public void setWhitelist(List<String> whitelist) {
            this.whitelist = whitelist;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
    }

    private class English {
        private boolean enabled = false;
        private String description = "Timeout users for typing non-English characters in chat.";
        private int min_chars = 10;
        private int max_foreign = 5;
        private double max_percentage = 0.9;

        private int stream_status = 200;
        private boolean raid = false;
        private boolean announce = true;
        private int announce_cooldown = 60000;
        private String message = "Latin characters only please.";
        private int timeout_duration = 30;
        private boolean exponential = true;
        private int base = 3;
        private int reset_strike = 180000;
        private Exempt exempt;

        public English(Exempt exempt) {
            this.exempt = exempt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMin_chars() {
            return min_chars;
        }

        public void setMin_chars(int min_chars) {
            this.min_chars = min_chars;
        }

        public int getMax_foreign() {
            return max_foreign;
        }

        public void setMax_foreign(int max_foreign) {
            this.max_foreign = max_foreign;
        }

        public double getMax_percentage() {
            return max_percentage;
        }

        public void setMax_percentage(double max_percentage) {
            this.max_percentage = max_percentage;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }

        public boolean isRaid() {
            return raid;
        }

        public void setRaid(boolean raid) {
            this.raid = raid;
        }

        public boolean isAnnounce() {
            return announce;
        }

        public void setAnnounce(boolean announce) {
            this.announce = announce;
        }

        public int getAnnounce_cooldown() {
            return announce_cooldown;
        }

        public void setAnnounce_cooldown(int announce_cooldown) {
            this.announce_cooldown = announce_cooldown;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public Exempt getExempt() {
            return exempt;
        }

        public void setExempt(Exempt exempt) {
            this.exempt = exempt;
        }
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

    public int getRaid_count() {
        return raid_count;
    }

    public void setRaid_count(int raid_count) {
        this.raid_count = raid_count;
    }

    public int getRaid_timeout() {
        return raid_timeout;
    }

    public void setRaid_timeout(int raid_timeout) {
        this.raid_timeout = raid_timeout;
    }

    public Caps getCaps() {
        return caps;
    }

    public void setCaps(Caps caps) {
        this.caps = caps;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public Zalgo getZalgo() {
        return zalgo;
    }

    public void setZalgo(Zalgo zalgo) {
        this.zalgo = zalgo;
    }

    public Emotes getEmotes() {
        return emotes;
    }

    public void setEmotes(Emotes emotes) {
        this.emotes = emotes;
    }

    public Emojis getEmojis() {
        return emojis;
    }

    public void setEmojis(Emojis emojis) {
        this.emojis = emojis;
    }

    public Repetition getRepetition() {
        return repetition;
    }

    public void setRepetition(Repetition repetition) {
        this.repetition = repetition;
    }

    public SoloSpam getSolo_spam() {
        return solo_spam;
    }

    public void setSolo_spam(SoloSpam solo_spam) {
        this.solo_spam = solo_spam;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public English getEnglish() {
        return english;
    }

    public void setEnglish(English english) {
        this.english = english;
    }
}
