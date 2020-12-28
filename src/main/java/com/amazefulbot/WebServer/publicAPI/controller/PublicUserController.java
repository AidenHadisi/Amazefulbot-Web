package com.amazefulbot.WebServer.publicAPI.controller;

import com.amazefulbot.WebServer.config.PublicAPI;
import com.amazefulbot.WebServer.publicAPI.models.User;
import com.amazefulbot.WebServer.publicAPI.service.PublicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@PublicAPI
@RequestMapping("/user")
public class PublicUserController {
    @Autowired
    private PublicUserService userService;

    @GetMapping( params = {"id"})
    public User getById(@RequestParam("id") int userId) {
        return userService.getById(userId);
    }


    @GetMapping(params = {"login"})
    public User getByLogin(@RequestParam("login") String login) {
        return userService.getByLogin(login);
    }
}
