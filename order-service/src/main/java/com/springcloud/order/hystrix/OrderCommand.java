package com.springcloud.order.hystrix;


import com.springcloud.entity.Product;
import com.springcloud.order.controller.ProductFeginClient;


public class OrderCommand extends BaseHystrixCommand {


    ProductFeginClient productFeginClient;

    private Integer id;

    public OrderCommand(ProductFeginClient productFeginClient, Integer id) {
        super();
        this.id = id;
        this.productFeginClient = productFeginClient;
    }

    @Override
    protected String run() throws Exception {
        Product product = productFeginClient.find(id);
        return product.getCaption();
    }

    @Override
    protected String getFallback() {

        return " 熔断降级";
    }
}
