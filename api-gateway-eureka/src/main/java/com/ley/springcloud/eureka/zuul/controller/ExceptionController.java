package com.ley.springcloud.eureka.zuul.controller;

import com.ley.springcloud.eureka.zuul.error.ErrorBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@EnableConfigurationProperties({ServerProperties.class})
@RestController
@Slf4j
public class ExceptionController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @Autowired
    private ServerProperties serverProperties;


    /**
     * 初始化ExceptionController
     *
     * @param errorAttributes
     */
    @Autowired
    public ExceptionController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        log.info("errorAttributes: {}", errorAttributes);
        this.errorAttributes = errorAttributes;
    }


    @RequestMapping(value = "/error")
    @ResponseBody
    public ErrorBean error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request));
        return ErrorBean.builder().statusCode((Integer) body.get("status")).timestamp(((Date) body.get("timestamp")).getTime())
                .message((String) body.get("message")).url((String) body.get("path")).build();
    }


    /**
     * Determine if the stacktrace attribute should be included.
     *
     * @param request the source request
     * @return if the stacktrace attribute should be included
     */
    protected boolean isIncludeStackTrace(HttpServletRequest request) {
        ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }


    /**
     * 获取错误的信息
     *
     * @param request
     * @param includeStackTrace
     * @return
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes,
                includeStackTrace);
    }

    /**
     * 是否包含trace
     *
     * @param request
     * @return
     */
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }


    /**
     * 实现错误路径,暂时无用
     *
     * @return
     */
    @Override
    public String getErrorPath() {
        return "";
    }
}
