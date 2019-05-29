package com.ley.springcloud.eureka.zuul.filter;


import com.ley.springcloud.eureka.zuul.filter.processor.ZuulFilterAwareProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

@Slf4j
public class PostErrorFilter extends SendErrorFilter {

    @Override
    public String filterType() {
        return super.filterType();
    }

    @Override
    public int filterOrder() {
        return 30;  //大于SendErrorFilter的值
    }


    @Override
    public boolean shouldFilter() {
        //TODO: 仅处理来自post过滤器引起的异常

        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) context.get(ZuulFilterAwareProcessor.FAILED_FILTER);

        if (failedFilter != null && failedFilter.filterType().equals(FilterConstants.POST_TYPE)) {
            return true;
        } else {
            return false;
        }
    }
}
