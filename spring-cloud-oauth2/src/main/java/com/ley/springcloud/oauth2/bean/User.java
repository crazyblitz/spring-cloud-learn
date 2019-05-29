package com.ley.springcloud.oauth2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String userName;    // 用户名
    private String passWord;    // 密码
    private String[] roles;     // 角色
}
