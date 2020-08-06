package com.springcloud.order.controller;

import com.springcloud.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductFeginClientCallBack implements ProductFeginClient {


    @Override
    public Product find(Integer id) {
        log.info("this is 熔断方法!");
        return Product.builder().caption("这里被熔断了！！！！").build();
    }
}
