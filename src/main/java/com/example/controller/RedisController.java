package com.example.controller;

import com.example.model.ResponseModal;
import com.example.model.User;
import com.example.redis.IRedisService;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("redis Controller")
@RestController
@RequestMapping(value = "/redis")
public class RedisController {
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

    @RequestMapping(value = "/redis/set", method = RequestMethod.POST)
    public ResponseModal redisSet(@RequestParam("value")String value){
        boolean isOk = redisService.set("name", value);
        return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
    }

    @RequestMapping(value = "/redis/get", method = RequestMethod.POST)
    public ResponseModal redisGet(){
        String name = redisService.get("name");
        return new ResponseModal(200, true,"success",name);
    }
}
