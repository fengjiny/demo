package com.example.demo.mongo;

import com.example.DemoApplication;
import com.example.mongodb.MongoUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
@Slf4j
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test2() {
        MongoUser user = new MongoUser();
        user.setName("test");
        mongoTemplate.insert(user);
    }
}
