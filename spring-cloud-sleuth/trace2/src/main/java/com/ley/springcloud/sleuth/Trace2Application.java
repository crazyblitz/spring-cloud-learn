package com.ley.springcloud.sleuth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Span;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class Trace2Application {


    @GetMapping(value = "/trace-2")
    public String trace(HttpServletRequest request) {
        log.info("TraceId: {},ParentSpanId: {},SpanId: {}",
                request.getHeader(Span.TRACE_ID_NAME), request.getHeader(Span.PARENT_ID_NAME),
                request.getHeader(Span.SPAN_ID_NAME));
        log.info("===<call trace-2>===");
        return "Trace";
    }

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }
}

