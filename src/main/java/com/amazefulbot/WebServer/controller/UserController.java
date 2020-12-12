/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.controller;


import com.amazefulbot.WebServer.config.AuthenticatedUser;
import com.amazefulbot.WebServer.config.UserPrincipal;
import com.amazefulbot.WebServer.models.Channel;
import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/name/{login}")
    public User findUserByName(@PathVariable ("login") String login, HttpSession session) {
        var user = userService.findByLogin(login);
        if(user == null)  throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        session.setAttribute("user", user);
        return user;
    }

//    @GetMapping({"", "/"})
//    @ResponseBody
//    public User getHome(HttpSession session) {
//        return (User) session.getAttribute("user");
//    }

    @GetMapping(value = "/current")
    @ResponseBody
    public Data currentUserName(@AuthenticatedUser UserPrincipal principal) {
        return new Data(principal.getUser(), principal.getCurrent_channel());
    }

    @GetMapping(value = "/channel")
    @ResponseBody
    public Channel currentChannel(@AuthenticatedUser UserPrincipal principal) {
        return principal.getCurrent_channel();
    }


    private class Data {
        private  Channel channel;
        private User user;

        public Data(User user, Channel channel) {
            this.channel = channel;
            this.user = user;
        }

        public Channel getChannel() {
            return channel;
        }

        public void setChannel(Channel channel) {
            this.channel = channel;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }
}
