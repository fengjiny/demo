package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();
}