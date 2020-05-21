package com.kk.service;

import com.kk.domain.User;

import java.util.List;

public interface UserService {
    public User findUserById(Integer id);
    public List<User> findUserAll();
}
