package com.ley.springcloud.hystrix.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * init hystrix request context
 *
 * @see HystrixRequestContext
 **/
@WebFilter(filterName = HystrixRequestContextServletFilter.FILTER_NAME, urlPatterns = HystrixRequestContextServletFilter.URL_PATTERNS, asyncSupported = true)
@Slf4j
public class HystrixRequestContextServletFilter implements Filter {

    public static final String URL_PATTERNS = "/*";

    public static final String FILTER_NAME = "hystrixRequestContextServletFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //初始化Hystrix请求上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            //请求正常通过
            chain.doFilter(request, response);
        } finally {
            //关闭Hystrix请求上下文
            context.shutdown();
        }
    }

    @Override
    public void destroy() {

    }
}
