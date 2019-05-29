package com.ley.springcloud.eureka.zuul;

import com.ley.springcloud.eureka.zuul.filter.processor.ZuulFilterAwareProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan(basePackages = "com.ley.springcloud.eureka.zuul.filter")
public class EurekaZuulApplication {

    /**
     * 版本升级的Zuul Pattern Bean<br/>
     * 将形如userservice-v1这样命名规则--->/v1/userservice/**的路由匹配规则
     */
    //@Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)=(?<version>v.+$)", "${version}/${name}"
        );
    }


    /**
     * 动态路由<br/>
     * Spring Cloud Zuul整合Spring Cloud Config实现动态路由<br/>
     * 修改完路由的配置文件后,需要发送PUST请求/refresh进行刷新配置信息<br/>
     * API网关服务在Git仓库的配置文件名称完全取决于网关应用配置文件<br/>
     * bootstrap.yaml中spring.application.name属性配置值
     **/
//    @RefreshScope
//    @ConfigurationProperties("zuul")
//    public ZuulProperties zuulProperties() {
//        return new ZuulProperties();
//    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE-300)
    public FilterRegistrationBean characterEncodingFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        filterRegistrationBean.setFilter(characterEncodingFilter);
        return filterRegistrationBean;
    }

    public static void main(String[] args) {
//        FilterProcessor.setProcessor(new ZuulFilterAwareProcessor());
        SpringApplication.run(EurekaZuulApplication.class, args);
    }
}
