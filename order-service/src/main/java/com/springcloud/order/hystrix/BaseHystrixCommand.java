//package com.springcloud.order.hystrix;
//
//import com.netflix.hystrix.*;
//
//public abstract class BaseHystrixCommand extends HystrixCommand<String> {
//    protected BaseHystrixCommand() {
//        super(setter());
//    }
//
//    private static Setter setter() {
//        //服务分组
//        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("order_product");
//        //服务标识
//        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("product");
//        // 线程池名称
//        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("order_product_pool");
//
//        //withCoreSize 线程池大小为50
//        //withKeepAliveTimeMinutes 线程存活时间为15秒
//        //withQueueSizeRejectionThreshold 队列等待的阈值为100,超过100拒绝执行
//        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter()
//                .withCoreSize(50)
//                .withKeepAliveTimeMinutes(15)
//                .withQueueSizeRejectionThreshold(50);
//
//        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
//                //使用线程池方式进行服务隔离
//                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
//                //禁止启用超时
//                .withExecutionTimeoutEnabled(false);
//        return HystrixCommand.Setter
//                .withGroupKey(groupKey)
//                .andCommandKey(commandKey)
//                .andThreadPoolKey(threadPoolKey)
//                .andCommandPropertiesDefaults(commandProperties)
//                .andThreadPoolPropertiesDefaults(threadPoolProperties);
//    }
//
//}
