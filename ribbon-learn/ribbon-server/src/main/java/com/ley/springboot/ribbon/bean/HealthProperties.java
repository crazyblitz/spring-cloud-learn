package com.ley.springboot.ribbon.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

@ConfigurationProperties(prefix = "spring.health")
public class HealthProperties {

    private String id;

    private String state;

    private Date timestamp;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HealthProperties{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
