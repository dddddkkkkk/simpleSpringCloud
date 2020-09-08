package com.springcloud.order.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.netflix.client.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @Author: dongkuiliu
 * @Date : created in 17:04 2020/8/12
 * @Description
 */
public class ExceptionUtils {
    /**
     * 静态方法
     *      返回值: SentinelClientHttpResponse
     *      参数 : request , byte[] , clientRquestExcetion , blockException
     */
    //限流熔断业务逻辑
    public static SentinelClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        return new SentinelClientHttpResponse("abc");
    }

    //异常降级业务逻辑
    public static SentinelClientHttpResponse handleFallback(HttpRequest request, byte[] body,
                                                            ClientHttpRequestExecution execution, BlockException ex) {
        return new SentinelClientHttpResponse("def");
    }
}
