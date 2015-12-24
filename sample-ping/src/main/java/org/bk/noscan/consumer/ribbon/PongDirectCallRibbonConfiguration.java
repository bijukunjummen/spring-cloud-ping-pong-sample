package org.bk.noscan.consumer.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PongDirectCallRibbonConfiguration extends RibbonClientConfiguration {

    @Bean
    @Override
    public ServerList<Server> ribbonServerList(IClientConfig clientConfig) {
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(clientConfig);
        return serverList;
    }

}
