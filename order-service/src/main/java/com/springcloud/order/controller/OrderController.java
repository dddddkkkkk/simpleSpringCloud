package com.springcloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.springcloud.constants.ServiceUrlConstant;
import com.springcloud.entity.Product;
import com.springcloud.order.hystrix.OrderCommand;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "orderFallBack")
public class OrderController {

    //注入restTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入DiscoveryClient :
     * springcloud提供的获取原数组的工具类
     * 调用方法获取服务的元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    ProductFeginClient productFeginClient;


    /**
     * 基于ribbon的形式调用远程微服务
     * 1.使用@LoadBalanced声明RestTemplate
     * 2.使用服务名称替换ip地址
     */
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable Integer id) {
//        Product product = null;
//        String pro = "http://PRODUCT-SERVICE";
//        product = restTemplate.getForObject(pro + "/product/" + id, Product.class);
        String product = new OrderCommand(productFeginClient, id).execute();
        return product;
    }


    @PostMapping("/id")
    @ResponseBody
    public Product order(@PathVariable("id") Integer id) {
        Product forObject = restTemplate.getForObject(ServiceUrlConstant.PRODUCT_URL.concat("/")
                        .concat(id + ""),
                Product.class);
        return forObject;
    }
}
