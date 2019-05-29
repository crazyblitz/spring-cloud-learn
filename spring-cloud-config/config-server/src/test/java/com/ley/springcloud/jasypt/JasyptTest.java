package com.ley.springcloud.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
public class JasyptTest {

    @Autowired(required = false)
    private StringEncryptor encryptor;

    @Test
    public void testEncrypt() {
        String password = "root";
        System.out.println(encryptor.encrypt(password));
    }
}
