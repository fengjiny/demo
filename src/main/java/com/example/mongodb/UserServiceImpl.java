package com.example.mongodb;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("mongoUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<MongoUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public MongoUser getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void update(MongoUser user) {
        userDao.update(user);
    }

    @Override
    public void insert(MongoUser user) {
        userDao.insert(user);
    }

    @Override
    public void insertAll(List<MongoUser> users) {
        userDao.insertAll(users);
    }

    @Override
    public void remove(Integer id) {
        userDao.remove(id);
    }

    @Override
    public List<MongoUser> findByPage(MongoUser user, Pageable pageable) {
        return userDao.findByPage(user, pageable);
    }
}
