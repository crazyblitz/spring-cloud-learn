package com.ley.springcloud.feign.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     * 配置Feign的请求拦截器
     * **/
    @Bean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }


    /**
     * feign的超时时间和读取超时时间配置<br/>
     * 连接超时时间(ms),默认值
     * **/
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
}
