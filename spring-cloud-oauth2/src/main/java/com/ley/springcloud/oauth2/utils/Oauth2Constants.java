package com.ley.springcloud.oauth2.utils;

import com.ley.springcloud.oauth2.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Oauth2Constants {

    public static List<User> users = new ArrayList<>(8);

    static {
        users.add(new User(UUID.randomUUID().toString(), "刘恩源", "123456",new String[]{"ROLE_ADMIN","ROLE_USER"}));
        users.add(new User(UUID.randomUUID().toString(), "刘恩源1", "123456",new String[]{"ROLE_ADMIN","ROLE_USER"}));
        users.add(new User(UUID.randomUUID().toString(), "刘恩源2", "123456",new String[]{"ROLE_ADMIN","ROLE_USER"}));
        users.add(new User(UUID.randomUUID().toString(), "刘恩源3", "123456",new String[]{"ROLE_ADMIN","ROLE_USER"}));
        users.add(new User(UUID.randomUUID().toString(), "刘恩源4", "123456",new String[]{"ROLE_ADMIN","ROLE_USER"}));
    }
}
