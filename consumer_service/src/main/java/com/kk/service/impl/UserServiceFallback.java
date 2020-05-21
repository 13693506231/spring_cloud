package com.kk.service.impl;

import com.kk.domain.User;
import com.kk.service.UserService;
import org.springframework.stereotype.Component;

@Component//注入Spring容器中
public class UserServiceFallback implements UserService {
    @Override
    public User getUserById222(Integer id) {
        User user = new User();
        user.setName("用户信息不存在");
        return user;
    }
}
