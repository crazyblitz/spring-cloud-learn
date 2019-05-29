package com.ley.springcloud.eureka.zuul.filter.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Zuul感知过滤器,得到当前过滤器是处于哪个阶段
 **/
public class ZuulFilterAwareProcessor extends FilterProcessor {

    /**
     * 异常过滤器
     **/
    public static final String FAILED_FILTER = "failed.filter";

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext context = RequestContext.getCurrentContext();
            context.set(FAILED_FILTER, filter);
            throw e;
        }
    }
}
