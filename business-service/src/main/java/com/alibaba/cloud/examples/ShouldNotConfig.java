package com.alibaba.cloud.examples;

import org.springframework.cloud.client.loadbalancer.LoadBalancerProperties;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShouldNotConfig {

    @Bean
    public BlockingLoadBalancerClient BlockingLoadBalancerClient(LoadBalancerClientFactory loadBalancerClientFactory,
                                                                 LoadBalancerProperties properties){
        return new BlockingLoadBalancerClient(loadBalancerClientFactory,properties);

    }
}
