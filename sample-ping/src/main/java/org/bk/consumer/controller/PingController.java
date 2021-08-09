package org.bk.consumer.controller;

import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.service.PongClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PingController {

    private final PongClient pongClient;

    public PingController(PongClient pongClient) {
        this.pongClient = pongClient;
    }

    @RequestMapping("/dispatch")
    public Mono<ResponseEntity<MessageAcknowledgement>> sendMessage(@RequestBody Message message) {
        return this.pongClient.sendMessage(message).map(ack -> ResponseEntity.ok(ack));
    }
}
