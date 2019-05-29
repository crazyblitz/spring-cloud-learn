package com.ley.springcloud.feign.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign请求接口的时候,会进入{@link feign.RequestInterceptor#apply(RequestTemplate)}
 * 方法.<br/>
 *
 * @see feign.RequestInterceptor
 **/
public class FeignRequestInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate template) {

    }
}
