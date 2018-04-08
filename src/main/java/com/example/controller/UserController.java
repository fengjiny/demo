package com.example.controller;


import com.example.model.User;
import com.example.mongodb.MongoUser;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Api("用户接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ApiOperation("查看所有用户")
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum,
                              @PathVariable("pageSize") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @ApiOperation("根据id查询用户")
    @RequestMapping(value="/one/{id}",method = RequestMethod.POST)
    @Cacheable(value = "getOneVideo")
    public void getOneVideo(@PathVariable Integer id){
        System.out.println("没redis缓存");
//        return videoMapper.selectByPrimaryKey(id);
    }

    @ApiOperation("mongo数据库添加用户")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String test(@RequestParam("name") String name) {
        MongoUser user = new MongoUser();
        user.setUserId("1999");
        user.setName(name);
        user.setAge("23");
        user.setPassword("123");
        user.setPhone("13122222222");
        mongoTemplate.insert(user);
        return "success";
    }

    @ApiOperation("mongo数据库添加用户test2")
    @RequestMapping(value = "/insert/{name}",method = RequestMethod.POST)
    public String test2(@PathVariable String name) {
        MongoUser user = new MongoUser();
        user.setName(name);
        mongoTemplate.insert(user);
        return "success";
    }

    @ApiOperation("hello World")
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloWorld(){
        return "Hello World!!!";
    }
}
