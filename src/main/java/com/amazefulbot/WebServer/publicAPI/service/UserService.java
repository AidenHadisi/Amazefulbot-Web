package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.User;

import java.util.Optional;

public interface UserService {
    User getById(int userId);
    User getByLogin(String login);
}
