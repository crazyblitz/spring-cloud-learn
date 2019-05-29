package com.ley.springcloud.eureka.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@ConditionalOnWebApplication
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@Configuration
public class ErrorConfig {

    @Autowired
    private ServerProperties serverProperties;

    /**
     * @see org.springframework.boot.autoconfigure.web.BasicErrorController
     **/
    @Bean
    public DefaultErrorAttributes errorAttributes() {
//        return new DefaultErrorAttributes();
        return new MyErrorAttributes();
    }
}
