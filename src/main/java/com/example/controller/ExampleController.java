package com.example.controller;

import com.example.model.ResponseModal;
import com.example.model.User;
import com.example.redis.IRedisService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/example")
public class ExampleController {
    @Autowired
    private UserService userService;

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseModal users(){
        List<User> users = userService.getAllUser();
        ResponseModal modal = new ResponseModal(200,true,"",users);
        return modal;
    }

    @RequestMapping("/redis/set")
    public ResponseModal redisSet(@RequestParam("value")String value){
        boolean isOk = redisService.set("name", value);
        return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
    }

    @RequestMapping("/redis/get")
    public ResponseModal redisGet(){
        String name = redisService.get("name");
        return new ResponseModal(200, true,"success",name);
    }
}
