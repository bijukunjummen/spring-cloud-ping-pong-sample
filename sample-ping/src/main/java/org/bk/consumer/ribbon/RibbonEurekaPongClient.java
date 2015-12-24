package org.bk.consumer.ribbon;

import com.google.common.collect.Maps;
import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.feign.PongClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonPongClient")
public class RibbonEurekaPongClient implements PongClient {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Override
    public MessageAcknowledgement sendMessage(Message message) {
        HttpEntity<Message> requestEntity = new HttpEntity<>(message);
        ResponseEntity<MessageAcknowledgement> response =  this.restTemplate.exchange("http://samplepong/message", HttpMethod.POST, requestEntity, MessageAcknowledgement.class, Maps.newHashMap());
        return response.getBody();
    }

}
