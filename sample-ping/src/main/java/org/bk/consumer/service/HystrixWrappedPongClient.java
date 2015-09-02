package org.bk.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.feign.PongClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hystrixPongClient")
public class HystrixWrappedPongClient implements PongClient {

    @Autowired
    @Qualifier("pongClient")
    private PongClient feignPongClient;

    @Override
    @HystrixCommand(groupKey = "pongGroup", fallbackMethod = "fallBackCall")
    public MessageAcknowledgement sendMessage(Message message) {
        return this.feignPongClient.sendMessage(message);
    }

    public MessageAcknowledgement fallBackCall(Message message) {
        MessageAcknowledgement fallback = new MessageAcknowledgement(message.getId(), message.getPayload(), "FAILED SERVICE CALL! - FALLING BACK");
        return fallback;
    }
}
