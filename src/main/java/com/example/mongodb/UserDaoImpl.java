package com.example.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



@Repository("userDao")
public class UserDaoImpl implements UserDao {

    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    @Override
    public List<MongoUser> findAll() {
        return mongoTemplate.findAll(MongoUser.class);
    }

    /**
     * 根据id得到对象
     */
    @Override
    public MongoUser getUser(Integer id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), MongoUser.class);
    }

    /**
     * 插入一个用户
     */
    @Override
    public void insert(MongoUser user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据id删除一个用户
     */
    @Override
    public void remove(Integer id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query,MongoUser.class);
    }



    /**
     * 分页查找
     *
     * user代表过滤条件
     *
     * pageable代表分页bean
     */
    @Override
    public List<MongoUser> findByPage(MongoUser user, Pageable pageable) {
        Query query = new Query();
        if (user != null && user.getName() != null) {
            //模糊查询
            query = new Query(Criteria.where("name").regex("^" + user.getName()));
        }
        List<MongoUser> list = mongoTemplate.find(query.with(pageable), MongoUser.class);
        return list;
    }

    /**
     * 根据id更新
     */
    @Override
    public void update(MongoUser user) {
        Criteria criteria = Criteria.where("id").is(user.getUserId());
        Query query = new Query(criteria);
        Update update = Update.update("name", user.getName()).set("age", user.getAge());
        mongoTemplate.updateMulti(query, update, MongoUser.class);
    }

    /**
     * 插入一个集合
     */
    @Override
    public void insertAll(List<MongoUser> users) {
        mongoTemplate.insertAll(users);
    }
}
