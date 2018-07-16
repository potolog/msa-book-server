package com.amano.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.OrderedHealthAggregator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EurekaHealthCheckHandler;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class EurekaHealthCheckHandlerConfiguration {

    @Autowired(required = false)
    private HealthAggregator healthAggregator = new OrderedHealthAggregator();

    @Bean
    @ConditionalOnMissingBean
    public EurekaHealthCheckHandler eurekaHealthCheckHandler() {
        return new EurekaHealthCheckHandler(healthAggregator);
    }

}
