package com.example.mongodb;

import com.example.model.User;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserDao {
    List<MongoUser> findAll();

    MongoUser getUser(Integer id);

    void update(MongoUser user);

    void insert(MongoUser user);

    void insertAll(List<MongoUser> users);

    void remove(Integer id);

    List<MongoUser> findByPage(MongoUser user, Pageable pageable);
}
