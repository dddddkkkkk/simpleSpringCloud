package com.springcloud.constants;

public class FilterTypeConstant {
    /**
     * 请求在路由之前被执行
     */
    public static final String PRE = "pre";

    /**
     * 在路由请求时调用
     */
    public static final String ROUTING = "routing";
    /**
     * 在routing和errror过滤器之后调用
     */
    public static final String POST = "post";
    /**
     * 处理请求时发生错误调用
     */
    public static final String ERROR = "error";

}
