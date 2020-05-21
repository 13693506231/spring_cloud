package com.kk.controller;

import com.kk.domain.User;
import com.kk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Value("${server.port}")
    private String port;
    @Value("${server.name}")
    private String name;
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUserById(Integer id){
        User user = userService.findUserById(id);
        System.out.println("服务【"+port+"】被调用");
        user.setNote("服务【"+port+"】被调用");
        user.setName(name);
        return user;
    }
    @RequestMapping("/getUserAll")
    public List<User> getUserAll(){
        List<User> users = userService.findUserAll();
        System.out.println("服务【"+port+"】被调用");
        users.get(0).setNote("服务【"+port+"】被调用");
        return users;
    }
}
