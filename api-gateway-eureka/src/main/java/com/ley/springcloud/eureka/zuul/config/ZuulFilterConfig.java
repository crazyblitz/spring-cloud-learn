package com.ley.springcloud.eureka.zuul.config;

import com.ley.springcloud.eureka.zuul.filter.AccessFilter;
import com.ley.springcloud.eureka.zuul.filter.ErrorFilter;
import com.ley.springcloud.eureka.zuul.filter.PostErrorFilter;
import com.ley.springcloud.eureka.zuul.filter.ZuulEncodingFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ZuulFilter.class)
public class ZuulFilterConfig {

//    @Bean
//    @ConditionalOnMissingBean
//    public AccessFilter accessFilter(){
//        return new AccessFilter();
//    }

    @Bean
    @ConditionalOnMissingBean
    public ZuulEncodingFilter zuulEncodingFilter() {
        return new ZuulEncodingFilter();
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public PostErrorFilter errorFilter(){
//        return new PostErrorFilter();
//    }


    @Bean
    @ConditionalOnMissingBean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

}
