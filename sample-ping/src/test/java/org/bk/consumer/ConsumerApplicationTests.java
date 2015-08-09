package org.bk.consumer;

import com.netflix.config.DynamicPropertyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PingApplication.class)
@WebAppConfiguration
public class ConsumerApplicationTests {


    @Test
    public void testArchaiusProperty() {
        assertThat(DynamicPropertyFactory.getInstance().getStringProperty("testkey", "").get(), equalTo("testvalue"));
        assertThat(DynamicPropertyFactory.getInstance().getStringProperty("another.key", "").get(), equalTo("anotherkeyvalue"));
    }

}
