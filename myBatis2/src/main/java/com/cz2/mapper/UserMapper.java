package com.cz2.mapper;

import com.cz2.model.User;

import java.util.List;

public interface UserMapper {
    public User getUserById(int id);
    public List<User> getUserList();
    public void addUser(User user);
    public void delUser(int id);
    public void updateUser(User user);
    public List<User> getUserByNameAndPassword(User user);
}
