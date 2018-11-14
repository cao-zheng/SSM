package com.cz.service.impl;

import com.cz.mapper.UserMapper;
import com.cz.model.User;
import com.cz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }
}
