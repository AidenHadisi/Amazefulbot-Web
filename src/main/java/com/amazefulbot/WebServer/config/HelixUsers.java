/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HelixUsers implements Serializable {
    private List<HelixUser> data;

    public HelixUsers() {
        this.data = new ArrayList<>();
    }

    public List<HelixUser> getData() {
        return data;
    }

    public void setUsers(List<HelixUser> data) {
        this.data = data;
    }

    public HelixUser getUser() {
        return data.get(0);
    }

    public HelixUsers(List<HelixUser> data) {
        this.data = data;
    }

}
