package org.bk.consumer.service;

import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import reactor.core.publisher.Mono;

public interface PongClient {
    Mono<MessageAcknowledgement> sendMessage(Message message);
}