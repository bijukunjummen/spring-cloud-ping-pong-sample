package org.bk.consumer;

import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.niws.client.http.RestClient;
import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.feign.PongClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.core.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PingApplication.class)
@WebAppConfiguration
public class ConsumerApplicationTests {

    @Test
    public void testContextLoaded() {
    }

}
