package com.amazefulbot.WebServer.publicAPI.service;

import com.amazefulbot.WebServer.publicAPI.models.User;
import com.amazefulbot.WebServer.publicAPI.repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PublicUserServiceImpl implements PublicUserService {

    @Autowired
    private PublicUserRepository publicUserRepository;

    @Override
    public User getById(int userId) {
        var user = publicUserRepository.findByUserId(userId);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
        }
        return user.get();
    }

    @Override
    public User getByLogin(String login) {
        var user = publicUserRepository.findByLogin(login);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
        }
        return user.get();
    }
}
