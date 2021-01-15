package com.dragon.mybatisxml.mapper;

import com.dragon.mybatisxml.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Slf4j
class UserDaoTest {

    @Resource
    UserJdbcDao userJdbcDao;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        userJdbcDao.insert(user);
        log.info("userId:{}",user.getId());
    }

    @Test
    void insert0() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        userJdbcDao.insert(user);
        log.info("userId:{}",user.getId());
    }

    @Test
    void selectById(){
        User user = userJdbcDao.selectById(4);
        log.info("user:{}", user.toString());
    }

    @Test
    void selectByUsername(){
        User user = userJdbcDao.selectByUsername("张三");
        log.info("user:{}", user.toString());
    }

    @Test
    void updateById(){
        User user = userJdbcDao.selectById(4);
        user.setUsername("李四");
        Integer count = userJdbcDao.updateById(user);
        log.info("count:{}",count);
    }

    @Test
    void deleteById(){
        Integer count = userJdbcDao.deleteById(4);
        log.info("count:{}",count);
    }

}