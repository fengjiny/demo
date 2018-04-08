package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int addUser(User user) {
        return userDAO.insert(user);
    }

    public List<User> findAllUser(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return userDAO.selectAllUser();
    }

    public List<User> getAllUser() {

        return userDAO.selectAllUser();
    }
}
