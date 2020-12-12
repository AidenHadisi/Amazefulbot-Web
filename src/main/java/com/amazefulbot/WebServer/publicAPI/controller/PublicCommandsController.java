//package com.amazefulbot.WebServer.publicAPI.controller;
//
//
//import com.amazefulbot.WebServer.config.PublicAPI;
//import com.amazefulbot.WebServer.publicAPI.models.Commands;
//import com.amazefulbot.WebServer.publicAPI.service.CommandsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Optional;
//
//
//@PublicAPI
//@RequestMapping("/commands")
//public class PublicCommandsController {
//    @Autowired
//    private CommandsService commandsService;
//
//    @GetMapping(value = "/{id}")
//
//    public print getChannelCommandsByChannelId(@PathVariable("id") int id) {
//
//        Commands[] allByChannelId = commandsService.getAllByChannelId(id);
//
//        return new print(id, allByChannelId);
//    }
//
//    private class print {
//        private int channel_id;
//        private int total;
//        private Commands[] commands;
//
//        public print(int channel_id, Commands[] commands) {
//            this.channel_id = channel_id;
//            this.total = commands.length;
//            this.commands = commands;
//        }
//
//        public int getChannel_id() {
//            return channel_id;
//        }
//
//        public void setChannel_id(int channel_id) {
//            this.channel_id = channel_id;
//        }
//
//        public int getTotal() {
//            return total;
//        }
//
//        public void setTotal(int total) {
//            this.total = total;
//        }
//
//        public Commands[] getCommands() {
//            return commands;
//        }
//
//        public void setCommands(Commands[] commands) {
//            this.commands = commands;
//        }
//    }
//
//}
