package org.bk.producer.service;

import org.bk.producer.domain.Message;
import org.bk.producer.domain.MessageAcknowledgement;

public interface MessageHandlerService {
    MessageAcknowledgement handleMessage(Message message);
}
