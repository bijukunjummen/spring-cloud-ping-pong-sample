package org.bk.consumer.ribbon;

import org.bk.consumer.PingApplication;
import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.feign.PongClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PingApplication.class)
public class RibbonDirectPongClientTest {
    @Autowired
    @Qualifier("ribbonDirectPongClient")
    private PongClient ribbonPongClient;

    @Test
    public void testRemoteCall() {
        MessageAcknowledgement ack = this.ribbonPongClient.sendMessage(new Message("id", "some payload"));
        assertThat(ack.getReceived(), equalTo("some payload"));
    }
}
