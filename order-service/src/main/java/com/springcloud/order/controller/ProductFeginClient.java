package com.springcloud.order.controller;

import com.springcloud.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service")
public interface ProductFeginClient {

    @GetMapping("/product/{id}")
    Product find(@PathVariable("id") Integer id);
}
