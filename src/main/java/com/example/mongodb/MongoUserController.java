package com.example.mongodb;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/mongo/user")
public class MongoUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/get/{id}")
    public MongoUser getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.remove(id);
        return "delete success";
    }

    @RequestMapping("/add")
    public String insert(@PathVariable String name) {
        MongoUser user =new MongoUser();
        user.setName(name);
        userService.insert(user);
        return "success";
    }

    @RequestMapping("/insert")
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

    @RequestMapping("/find/all")
    public List<MongoUser> find(){
        return userService.findAll();
    }

    @RequestMapping("/find/{start}")
    public List<MongoUser> findByPage(@PathVariable int start, MongoUser user){
        Pageable pageable=new PageRequest(start, 2);
        return userService.findByPage(user, pageable);
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id){
        MongoUser user =new MongoUser();
        userService.update(user);
        return "success";
    }

    @RequestMapping("/test/insert/{name}")
    public String test(@PathVariable String name) {
        MongoUser user = new MongoUser();
        user.setName(name);
        mongoTemplate.insert(user);
        return "success";
    }
}
