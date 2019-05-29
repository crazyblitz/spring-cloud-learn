package com.ley.springcloud.zipkin.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @see EnableZipkinStreamServer
 **/
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinServerStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStreamApplication.class, args);
    }
}
