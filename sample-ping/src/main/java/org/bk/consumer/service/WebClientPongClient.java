package org.bk.consumer.service;

import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientPongClient implements PongClient {
    private final WebClient.Builder webClientBuilder;

    public WebClientPongClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<MessageAcknowledgement> sendMessage(Message message) {
        return webClientBuilder.build()
                .post()
                .uri("http://sample-pong/message")
                .body(BodyInserters.fromValue(message))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(MessageAcknowledgement.class));
    }
}
