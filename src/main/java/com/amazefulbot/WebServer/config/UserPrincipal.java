/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.config;

import com.amazefulbot.WebServer.converter.ChannelReferenceConverter;
import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;


import java.io.Serializable;
import java.util.*;

public class UserPrincipal implements OAuth2User, Serializable {
    private User user;
    private Channel current_channel;
    private Map<String, Object> attributes;
    private Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.user.populateChannels();

        if(user.getPrimary_channel() != null) {
            var channel = new ChannelReferenceConverter().convert(user.getPrimary_channel());
            if (channel.isPresent()) {
                var channelGot = channel.get();
                channelGot.setDisplay_name(user.getDisplay_name());
                channelGot.setLogin(user.getLogin());
                channelGot.setType(user.getType());
                channelGot.setBroadcaster_type(user.getType());
                channelGot.setProfile_image_url(user.getProfile_image_url());
                this.current_channel = channelGot;
            }
        }
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(user.getType() == "affiliate") {
            authorities.add(new SimpleGrantedAuthority("ROLE_AFFILIATE"));
        }
        else if(user.getType() == "partner") {
            authorities.add(new SimpleGrantedAuthority("ROLE_PARTNER"));
        }
        return new UserPrincipal(
                user,
                authorities
        );
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }
    @Override
    public <A> A getAttribute(String name) {
        return (A) this.attributes.get(name);
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return user.getLogin();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getCurrent_channel() {
        return current_channel;
    }

    public void setCurrent_channel(Channel current_channel) {
        this.current_channel = current_channel;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
