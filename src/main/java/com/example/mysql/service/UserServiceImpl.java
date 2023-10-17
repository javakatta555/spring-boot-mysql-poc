package com.example.mysql.service;

import com.example.mysql.exceptions.UserNotFoundException;
import com.example.mysql.model.User;
import com.example.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll().stream().filter(User::isActive).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user;
        }
        throw new UserNotFoundException(userId);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId,User user) {
        Optional<User> userdb = userRepository.findById(userId);
        if(userdb.isPresent()){
            return userRepository.save(userdb.get());
        }
        throw new UserNotFoundException(userId);
    }

    @Override
    public User deleteUserByid(int id) {
        Optional<User> userdb = userRepository.findById(id);
        if(userdb.isPresent()){
            userdb.get().setActive(false);
            return userRepository.save(userdb.get());
        }
        throw new UserNotFoundException(id);
    }

}
