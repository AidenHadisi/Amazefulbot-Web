package com.amazefulbot.WebServer.config;

import java.util.Map;

public class TwitchOAuth2UserInfo {
    private Map<String, Object> attributes;

    public TwitchOAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return (String) this.attributes.get("sub");
    }

    public String getName() {
        return (String) this.attributes.get("preferred_username");
    }

    public String getClientId() {
        return (String) this.attributes.get("aud");
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
