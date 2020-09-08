package com.springcloud.order.config;


import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.springcloud.order.exception.ExceptionUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.misc.Contended;

@Configuration
public class Config {

    @Bean
    @LoadBalanced //使用客户端负载均衡
//    @SentinelRestTemplate(fallbackClass = ExceptionUtils.class,fallback = "handleFallback",
//            blockHandler = "handleBlock" ,blockHandlerClass = ExceptionUtils.class
//    )
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
