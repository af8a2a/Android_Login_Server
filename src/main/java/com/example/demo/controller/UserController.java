package com.example.demo.controller;

import com.example.demo.UserMapper.UserMapper;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private String Success="Hello";
    @Resource
     UserMapper userMapper;
    @GetMapping
    public List<User> getUser(){
        return userMapper.findAll();
    }

    @PostMapping
    public void addUser(User user){
         userMapper.save(user);
    }
    @GetMapping("/get")
    public boolean selectUser(String username){
        if(userMapper.select_username(username)!=null) return true;
        else return false;
    }

    @PostMapping("/register")
    public boolean register(User user){
        if(selectUser(user.getUsername())==false){
            userMapper.save(user);
            return true;
        }else{
            return false;
        }
    }
    @PostMapping("/reset")
    public boolean resetPassword(User user){
        if(selectUser(user.getUsername())==true&&user.getUsername()!=null){
            userMapper.setPassword(user);
            return true;
        }
        else return false;
    }
    @PostMapping("/login")
    public boolean login(User user){
        String postUsername=user.getUsername();
        String serverPassword=userMapper.select_username(postUsername).getPassword();
        if(selectUser(postUsername)&&user.getPassword().equals(serverPassword)){
          return true;
        }
        else return false;
    }
}
