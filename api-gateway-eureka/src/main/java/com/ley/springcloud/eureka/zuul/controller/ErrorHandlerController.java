package com.ley.springcloud.eureka.zuul.controller;

import com.ley.springcloud.eureka.zuul.error.ErrorBean;
import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@RestController
//public class ErrorHandlerController implements ErrorController {
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//
//
//    @GetMapping("/error")
//    public Object error() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
//        String message = (String) request.getAttribute("javax.servlet.error.message");
//        return ErrorBean.builder().exceptionDesc(exception.getCause().toString())
//                .message(message).statusCode(status).timestamp(System.currentTimeMillis()).build();
//    }
//}
