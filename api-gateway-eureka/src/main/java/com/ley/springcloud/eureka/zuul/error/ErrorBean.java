package com.ley.springcloud.eureka.zuul.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorBean {

    private String message;

    private Integer statusCode;

    private Long timestamp;

    private String url;
}
