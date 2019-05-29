package com.springcloud.config.server.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * properties property source loader and this class load properties file encoding is UTF-8
 *
 * @see org.springframework.boot.env.PropertiesPropertySourceLoader
 **/
@Slf4j
public class PropertiesPropertySourceLoader implements PropertySourceLoader {


    private static final String CHARSET_NAME = "utf-8";

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
                return propertiesPropertySource;
            }
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, CHARSET_NAME));
            log.info("properties: {}", properties);
            inputStream.close();
        } catch (IOException e) {
            log.error("load inputstream failure: {}", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("close IO failure: {}", e);
                }
            }
        }
        return properties;
    }
}
