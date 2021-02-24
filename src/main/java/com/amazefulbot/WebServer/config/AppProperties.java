/*
 * Copyright (c) 2021. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Auth auth = new Auth();
    private OAuth2 oauth2 = new OAuth2();

    public Auth getAuth() {
        return auth;
    }

    public OAuth2 getOauth2() {
        return oauth2;
    }

    public static class Auth {
        private String tokenSecret;
        private long tokenExpiration;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpiration() {
            return tokenExpiration;
        }

        public void setTokenExpiration(long tokenExpiration) {
            this.tokenExpiration = tokenExpiration;
        }
    }

    public static final class OAuth2 {
        private String authorizedRedirectUri;

        public OAuth2 authorizedRedirectUris(String authorizedRedirectUri) {
            this.authorizedRedirectUri = authorizedRedirectUri;
            return this;
        }

        public String getAuthorizedRedirectUri() {
            return authorizedRedirectUri;
        }
    }
}
