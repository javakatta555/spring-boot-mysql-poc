package com.example.mysql.service;

import com.example.mysql.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAllUser();

    public Optional<User> findUserById(int userId);

    public User saveUser(User user);

    public User updateUser(int id ,User user);

    public User deleteUserByid(int id);
}
