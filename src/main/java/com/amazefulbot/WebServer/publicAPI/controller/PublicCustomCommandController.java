package com.amazefulbot.WebServer.publicAPI.controller;

import com.amazefulbot.WebServer.config.PublicAPI;
import com.amazefulbot.WebServer.publicAPI.models.CustomCommand;
import com.amazefulbot.WebServer.publicAPI.service.PublicCustomCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@PublicAPI
@RequestMapping("/custom")
public class PublicCustomCommandController {
    @Autowired
    private PublicCustomCommandService customCommandService;

    @GetMapping(value = "/{id}")
    public Response getByChannelId(@PathVariable("id") int id) {

        CustomCommand[] allByChannelId = customCommandService.getByChannelId(id);

        return new Response(id, allByChannelId);
    }

    private class Response {
        private int channel_id;
        private int total;
        private CustomCommand[] commands;

        public Response(int channel_id, CustomCommand[] commands) {
            this.channel_id = channel_id;
            this.total = commands.length;
            this.commands = commands;
        }

        public int getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(int channel_id) {
            this.channel_id = channel_id;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public CustomCommand[] getCommands() {
            return commands;
        }

        public void setCommands(CustomCommand[] commands) {
            this.commands = commands;
        }
    }
}
