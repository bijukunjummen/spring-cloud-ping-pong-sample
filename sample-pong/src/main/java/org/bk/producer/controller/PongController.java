package org.bk.producer.controller;


import org.bk.producer.domain.Message;
import org.bk.producer.domain.MessageAcknowledgement;
import org.bk.producer.service.MessageHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    private final MessageHandlerService messageHandlerService;

    @Autowired
    public PongController(MessageHandlerService messageHandlerService) {
        this.messageHandlerService = messageHandlerService;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
        return new Resource<>(this.messageHandlerService.handleMessage(input));
    }

}
