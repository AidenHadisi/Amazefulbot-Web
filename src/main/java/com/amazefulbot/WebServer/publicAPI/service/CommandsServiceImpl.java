//package com.amazefulbot.WebServer.publicAPI.service;
//
//
//import com.amazefulbot.WebServer.publicAPI.models.Commands;
//import com.amazefulbot.WebServer.publicAPI.repository.PublicCommandsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Optional;
//
//@Service
//public class CommandsServiceImpl implements CommandsService {
//
//    @Autowired
//    private PublicCommandsRepository commandsRepository;
//
//    @Override
//    public Commands[] getAllByChannelId(int channelId) {
//        var commands = commandsRepository.findByChannelId(channelId);
//        if(commands.length == 0) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No commands found for this channel");
//        }
//        return commands;
//    }
//}
