package com.ley.springcloud.endpoint;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("endpoints.person")
public class PersonEndpoint extends AbstractEndpoint<Map<String, Object>> {

    public PersonEndpoint() {
        super("person", false);
    }

    @Override
    public Map<String, Object> invoke() {
        Map<String, Object> result = new HashMap<String, Object>();
        DateTime dateTime = DateTime.now();
        result.put("当前时间", DateFormatUtils.format(dateTime.toDate(),"yyyy-MM-dd HH:mm:ss"));
        result.put("当前时间戳", dateTime.getMillis());
        return result;
    }


}
