package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.User;

import java.util.Optional;

public interface PublicUserService {
    User getById(int userId);
    User getByLogin(String login);
}
