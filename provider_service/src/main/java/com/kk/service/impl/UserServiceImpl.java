package com.kk.service.impl;

import com.kk.domain.User;
import com.kk.mapper.UserMapper;
import com.kk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserById(Integer id) {
        if(id == 1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return userMapper.findById(id);
    }


    @Override
    public List<User> findUserAll() {
        return userMapper.findAll();
    }

}
