package com.springcloud.zuul.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.constants.FilterTypeConstant;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class LoginFilter extends ZuulFilter {
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("access-token");
        if (token == null || "".equals(token.trim())) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }

    @Override
    public String filterType() {
        return FilterTypeConstant.PRE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
