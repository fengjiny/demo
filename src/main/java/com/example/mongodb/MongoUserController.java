package com.example.mongodb;

import com.example.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("mongo-controller")
@RestController
@RequestMapping("/mongo/user")
public class MongoUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation("查询用户")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
    public MongoUser getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "userId", required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable int id) {
        userService.remove(id);
        return "delete success";
    }

    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "user", value = "mongo-实体user", required = true, dataType = "MongoUser")
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(@ApiParam("user") @RequestBody MongoUser user) {
        userService.insert(user);
        return "success";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertAll() {
        List<MongoUser> list = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            MongoUser user = new MongoUser();
//            user.setId(i);
            user.setName(i+"");
            list.add(user);
        }
        userService.insertAll(list);
        return "success";
    }

    @RequestMapping(value = "/find/all", method = RequestMethod.POST)
    public List<MongoUser> find(){
        return userService.findAll();
    }

    @RequestMapping(value = "/find/{start}", method = RequestMethod.POST)
    public List<MongoUser> findByPage(@PathVariable int start, MongoUser user){
        Pageable pageable=new PageRequest(start, 2);
        return userService.findByPage(user, pageable);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id){
        MongoUser user =new MongoUser();
        userService.update(user);
        return "success";
    }

    @RequestMapping(value = "/test/insert/{name}", method = RequestMethod.POST)
    public String test(@PathVariable String name) {
        MongoUser user = new MongoUser();
        user.setName(name);
        mongoTemplate.insert(user);
        return "success";
    }
}
