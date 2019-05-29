package com.ley.springcloud.eureka.zuul.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Slf4j
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
        result.remove("exception");
        log.info("error attributes: {}",result);
        return result;
    }
}
