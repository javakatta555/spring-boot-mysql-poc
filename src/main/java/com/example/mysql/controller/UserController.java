package com.example.mysql.controller;

import com.example.mysql.Util.CustomResponse;
import com.example.mysql.model.User;
import com.example.mysql.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping
    public ResponseEntity<Map> findAllUser(){
        return CustomResponse.ok(userService.findAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Map> findByUserId(@PathVariable int userId){
        return CustomResponse.ok(userService.findUserById(userId));
    }

    @PostMapping
    public ResponseEntity<Map> saveUser(@RequestBody @Valid User user){
        return CustomResponse.ok(userService.saveUser(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Map> updateUser(@PathVariable int userId, @RequestBody User user){
        return CustomResponse.ok(userService.updateUser(userId, user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map> deleteUserById(@PathVariable int userId){
        return CustomResponse.ok(userService.deleteUserByid(userId));
    }

}
