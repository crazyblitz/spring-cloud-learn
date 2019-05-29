package com.ley.springcloud.oauth2.service;

import com.ley.springcloud.oauth2.bean.User;
import com.ley.springcloud.oauth2.controller.UserController;
import com.ley.springcloud.oauth2.utils.Oauth2Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> tmpUsers = Oauth2Constants.users;
        for (User user : tmpUsers) {
            if (user.getUserName().equals(s)) {
                log.info("user: {}", user);
                return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), AuthorityUtils.createAuthorityList(user.getRoles()));
            }
        }
        throw new UsernameNotFoundException("用户[" + s + "]不存在");
    }
}
